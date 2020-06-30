package com.songjy.sharding.sphere.service.area;

import com.songjy.sharding.sphere.mapper.area.SysAreaMapper;
import com.songjy.sharding.sphere.model.area.SysArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author songjy
 * @date 2020-06-30
 */
@Service
public class AreaServiceImpl implements IAreaService {

    @Autowired
    private SysAreaMapper sysAreaMapper;

    @Override
    public Integer add(SysArea record) {
        return sysAreaMapper.insert(record);
    }
}