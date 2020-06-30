package com.songjy.sharding.sphere.service.order;

import com.songjy.sharding.sphere.mapper.order.OrderItemMapper;
import com.songjy.sharding.sphere.mapper.order.OrderMapper;
import com.songjy.sharding.sphere.model.order.Order;
import com.songjy.sharding.sphere.model.order.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author songjy
 * @date 2020-06-30
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public int add(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public int add(OrderItem record) {
        return orderItemMapper.insertSelective(record);
    }
}