package com.oguiller.multipleservlets.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.oguiller.multipleservlets.Service;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(ApiController.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private Service service;

    @Test
    public void testGetMessage() throws Exception {
        final String helloWorldText = "Hello World";
        final String message = "{\"message\": \""+helloWorldText+"\"}";
        given(service.getMessage()).willReturn(message);

        mvc.perform(get("/message")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("message", is(helloWorldText)));
    }

    @Test
    public void testPostMessage() throws Exception {
        final String helloWorldText = "Hello World";
        final String message = "{\"message\": \""+helloWorldText+"\"}";

        mvc.perform(post("/search/message")
                        .content(message)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }
}
