package com.salaryup.lazyboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = ("com"))
public class LazybootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LazybootApplication.class, args);
	}

}
