package com.oguiller.multipleservlets.it;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oguiller.multipleservlets.Service;
import com.oguiller.multipleservlets.api.ApiController;
import com.oguiller.multipleservlets.web.WebController;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleservletsApplicationTests {

	@Autowired WebController webController;

	@Autowired ApiController apiController;

	@Autowired Service service;

	@Test
	public void contextLoads() {
		assertThat(webController).isNotNull();
		assertThat(apiController).isNotNull();
		assertThat(service).isNotNull();
	}

}

