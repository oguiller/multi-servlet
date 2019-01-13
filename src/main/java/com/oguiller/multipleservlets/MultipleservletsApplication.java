package com.oguiller.multipleservlets;

import com.oguiller.multipleservlets.config.ApiConfig;
import com.oguiller.multipleservlets.config.ApplicationConfig;
import com.oguiller.multipleservlets.config.WebConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication(exclude=DispatcherServletAutoConfiguration.class)
@Import(ApplicationConfig.class)
public class MultipleservletsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleservletsApplication.class, args);
	}

}

