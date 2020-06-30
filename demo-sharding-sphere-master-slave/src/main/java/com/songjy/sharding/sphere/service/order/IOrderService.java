package com.songjy.sharding.sphere.service.order;

import com.songjy.sharding.sphere.model.order.Order;
import com.songjy.sharding.sphere.model.order.OrderItem;

/**
 * @author songjy
 * @date 2020-06-30
 */
public interface IOrderService {

    /**
     * 添加
     *
     * @param record 记录
     * @return 1：成功
     */
    int add(Order record);

    /**
     * 添加
     *
     * @param record 记录
     * @return 1：成功
     */
    int add(OrderItem record);
}
