package com.group6.booking4sportcentre;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.group6.booking4sportcentre.mapper")
public class Booking4sportcentreApplication {

	public static void main(String[] args) {
		SpringApplication.run(Booking4sportcentreApplication.class, args);
	}

}
