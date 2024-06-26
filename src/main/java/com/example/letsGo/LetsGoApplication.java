package com.example.letsGo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.example.letsGo.dao.mybatis.mapper")
public class LetsGoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LetsGoApplication.class, args);
	}

}
