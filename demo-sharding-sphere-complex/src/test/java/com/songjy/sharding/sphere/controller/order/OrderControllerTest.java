package com.songjy.sharding.sphere.controller.order;

import com.alibaba.fastjson.JSON;
import com.songjy.sharding.sphere.DemoShardingSphereApplicationTests;
import com.songjy.sharding.sphere.model.order.Order;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author songjy
 * @date 2020-06-30
 */
public class OrderControllerTest extends DemoShardingSphereApplicationTests {

    @Test
    public void addTest() throws Exception {

        Order order = new Order();
        order.setUserId(4);
        order.setOrderId(4);

        mockMvc.perform(post("/order/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(order))
                .session(mockHttpSession))
                .andDo(print())
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$.code").value("0"))
                .andReturn();
    }
}
