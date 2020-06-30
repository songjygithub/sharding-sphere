package com.songjy.sharding.sphere.mapper.order;

import com.songjy.sharding.sphere.model.order.OrderItem;
import org.apache.ibatis.annotations.Param;

public interface OrderItemMapper {
    int deleteByPrimaryKey(@Param("id") Long id, @Param("payDiscount") Integer payDiscount);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(@Param("id") Long id, @Param("payDiscount") Integer payDiscount);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);
}