package com.songjy.sharding.sphere.service.order;

import com.songjy.sharding.sphere.model.order.Order;
import com.songjy.sharding.sphere.model.order.OrderItem;

import java.time.LocalDate;

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

    /**
     * 初始化t_order表
     *
     * @param localDate 日期
     */
    void createOrderTable(LocalDate localDate);

    /**
     * 初始化t_order_item表
     *
     * @param localDate 日期
     */
    void createOrderItemTable(LocalDate localDate);
}
