package com.songjy.sharding.sphere.controller.area;

import com.alibaba.fastjson.JSON;
import com.songjy.sharding.sphere.DemoShardingSphereApplicationTests;
import com.songjy.sharding.sphere.model.area.SysArea;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author songjy
 * @date 2020-06-30
 */
public class AreaControllerTest extends DemoShardingSphereApplicationTests {

    @Test
    public void addTest() throws Exception {

        SysArea area = new SysArea();
        area.setAreaCode(110000);
        area.setAreaName("北京市");
        area.setLevel(1);
        area.setCityCode("010");
        area.setCenter("116.407394,39.904211");
        area.setParentId("-1");
        area.setDeleted(false);


        mockMvc.perform(post("/area/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(area))
                .session(mockHttpSession))
                .andDo(print())
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$.code").value("0"))
                .andReturn();
    }
}
