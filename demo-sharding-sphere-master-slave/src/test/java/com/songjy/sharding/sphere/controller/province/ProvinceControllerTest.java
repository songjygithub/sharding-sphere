package com.songjy.sharding.sphere.controller.province;

import com.alibaba.fastjson.JSON;
import com.songjy.sharding.sphere.DemoShardingSphereApplicationTests;
import com.songjy.sharding.sphere.model.province.Province;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * @author songjy
 * @date 2020-06-29
 */
public class ProvinceControllerTest extends DemoShardingSphereApplicationTests {

    @Test
    public void addTest() throws Exception {

        Province province = new Province();
        province.setName("江西");

        mockMvc.perform(post("/province/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(province))
                .session(mockHttpSession))
                .andDo(print())
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$.code").value("0"))
                .andReturn();
    }

    @Test
    public void selectByIdTest() throws Exception {

        for (int i = 0; i < 10; i++) {
            mockMvc.perform(get("/province/1")
                    .contentType(MediaType.APPLICATION_JSON)
                    //.content(JSON.toJSONString(province))
                    .session(mockHttpSession))
                    .andDo(print())
                    .andExpect(status().isOk())
                    //.andExpect(jsonPath("$.code").value("0"))
                    .andReturn();
        }
    }
}
