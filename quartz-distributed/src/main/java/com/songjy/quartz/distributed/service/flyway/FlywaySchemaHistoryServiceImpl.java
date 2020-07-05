package com.songjy.quartz.distributed.service.flyway;

import com.songjy.quartz.distributed.mapper.flyway.FlywaySchemaHistoryMapper;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author songjy
 * @date 2020-07-05
 */
@Service
public class FlywaySchemaHistoryServiceImpl implements IFlywaySchemaHistoryService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.flyway.locations}")
    private String flywayLocations;

    @Autowired
    private FlywaySchemaHistoryMapper flywaySchemaHistoryMapper;

    @Override
    public boolean upgradeSuccess() {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = resolver.getResources(flywayLocations + "/*/*.sql");
            List<String> list = Arrays.stream(resources).map(Resource::getFilename).sorted().collect(Collectors.toList());
            String last = FilenameUtils.getName(list.get(list.size() - 1));
            String latest = FilenameUtils.getName(flywaySchemaHistoryMapper.latestRecord().getScript());

            logger.info("{}>>{}", last, latest);

            return last.equals(latest);

        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }
}
