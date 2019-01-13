package com.oguiller.multipleservlets.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.oguiller.multipleservlets.Service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(WebController.class)
public class WebControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private Service service;

    @Test
    public void testGetMessage() throws Exception {
        final String helloWorldText = "Hello World";
        given(service.getMessage()).willReturn(helloWorldText);

        mvc.perform(get("/"))
                        .andExpect(status().isOk())
                        .andExpect(view().name("index"))
                        .andExpect(model().attribute("message", equalTo(helloWorldText)));
    }
}
