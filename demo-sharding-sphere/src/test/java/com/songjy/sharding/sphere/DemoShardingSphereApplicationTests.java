package com.songjy.sharding.sphere;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoShardingSphereApplication.class})
public abstract class DemoShardingSphereApplicationTests {

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    protected MockHttpSession mockHttpSession;
    protected MockHttpServletRequest mockHttpServletRequest;
    protected MockHttpServletResponse mockHttpServletResponse;

    @Before
    public void before() throws Exception {
        mockMvc = webAppContextSetup(wac).build();
        mockHttpSession = new MockHttpSession(wac.getServletContext());
        mockHttpServletRequest = new MockHttpServletRequest(wac.getServletContext());
        mockHttpServletResponse = new MockHttpServletResponse();
        mockHttpServletRequest.setSession(mockHttpSession);
    }

}
