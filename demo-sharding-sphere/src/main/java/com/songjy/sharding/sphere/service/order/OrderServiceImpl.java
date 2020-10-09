package com.songjy.sharding.sphere.service.order;

import com.songjy.sharding.sphere.mapper.order.OrderItemMapper;
import com.songjy.sharding.sphere.mapper.order.OrderMapper;
import com.songjy.sharding.sphere.model.order.Order;
import com.songjy.sharding.sphere.model.order.OrderItem;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Types;
import java.time.LocalDate;

import static com.songjy.sharding.sphere.common.Constants.SQL_DATABASE;
import static com.songjy.sharding.sphere.common.Constants.SQL_TABLE_EXIST;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author songjy
 * @date 2020-06-30
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Order record) {

        createOrderTable(LocalDate.now());
        createOrderTable(LocalDate.now().plusDays(1L));

        createOrderItemTable(LocalDate.now());
        createOrderItemTable(LocalDate.now().plusDays(1));

        return orderMapper.insertSelective(record);
    }

    @Override
    public int add(OrderItem record) {
        return orderItemMapper.insertSelective(record);
    }

    @Override
    public void createOrderTable(LocalDate localDate) {
        String dbName = jdbcTemplate.queryForObject(SQL_DATABASE, String.class);
        String suffix = localDate.getYear() + "_" + localDate.getMonthValue() + "_" + localDate.getDayOfMonth();
        Object[] args = {dbName, "t_order" + suffix};
        int[] argTypes = {Types.VARCHAR, Types.VARCHAR};
        Integer count = jdbcTemplate.queryForObject(SQL_TABLE_EXIST, args, argTypes, Integer.class);

        if (null != count && count >= 1) {
            return;
        }

        String createSql = String.format(createSql("template/sql/t_order.sql"), suffix);

        jdbcTemplate.execute(createSql);

        logger.info("语句{}执行成功", createSql);
    }

    @Override
    public void createOrderItemTable(LocalDate localDate) {
        String dbName = jdbcTemplate.queryForObject(SQL_DATABASE, String.class);
        String suffix = localDate.getYear() + "_" + localDate.getMonthValue() + "_" + localDate.getDayOfMonth();
        Object[] args = {dbName, "t_order_item" + suffix};
        int[] argTypes = {Types.VARCHAR, Types.VARCHAR};
        Integer count = jdbcTemplate.queryForObject(SQL_TABLE_EXIST, args, argTypes, Integer.class);

        if (null != count && count >= 1) {
            return;
        }

        String createSql = String.format(createSql("template/sql/t_order_item.sql"), suffix);

        jdbcTemplate.execute(createSql);

        logger.info("语句{}执行成功", createSql);
    }

    /**
     * @return SQL模板
     */
    private String createSql(String path) {
        try (InputStream inputStream = new ClassPathResource(path).getInputStream()) {
            return IOUtils.toString(inputStream, UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(path + "文件读取失败");
        }
    }
}