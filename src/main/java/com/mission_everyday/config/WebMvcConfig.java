package com.mission_everyday.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mission_everyday.interceptor.PermissionInterceptor;

@Configuration
	public class WebMvcConfig implements WebMvcConfigurer{
		
		@Autowired
		private PermissionInterceptor permissionInterceptor;
		

		@Override 
		public void addInterceptors(InterceptorRegistry registry) {
		  registry.addInterceptor(permissionInterceptor) .addPathPatterns("/**") 
		 
		  .excludePathPatterns("/user/sign_out", "/static/**", "/error"); 
		}

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) { 
			registry.addResourceHandler("/images/**")
			        .addResourceLocations("file:/home/ec2-user/upload_images/"); 
		
		}	
	}