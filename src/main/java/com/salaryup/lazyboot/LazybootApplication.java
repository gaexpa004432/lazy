package com.salaryup.lazyboot;


import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class LazybootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LazybootApplication.class, args);
	}

	/*@Bean
	public FilterRegistrationBean siteMeshFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new SiteMeshConfig());
		return filter;
	}*/




}
