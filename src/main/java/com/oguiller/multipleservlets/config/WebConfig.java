package com.oguiller.multipleservlets.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.oguiller.multipleservlets.web"})
@EnableWebMvc
public class WebConfig {
}
