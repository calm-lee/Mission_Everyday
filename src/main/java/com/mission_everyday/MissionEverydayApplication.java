package com.mission_everyday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MissionEverydayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MissionEverydayApplication.class, args);
	}

}
