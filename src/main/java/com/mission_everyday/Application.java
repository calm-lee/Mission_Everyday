package com.mission_everyday;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer{

    @PostConstruct
    public static void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
 
    }
	
}
