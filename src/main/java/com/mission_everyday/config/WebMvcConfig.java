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
		

		  @Override public void addInterceptors(InterceptorRegistry registry) {
		  registry.addInterceptor(permissionInterceptor) .addPathPatterns("/**") 
		  //� url�� �� � interceptor�� Ÿ�� �� ������, ���� /**�� � url�̴� Ÿ�� �ϰڴٴ� ��
		  .excludePathPatterns("/user/sign_out", "/static/**", "/error"); //���⿡ �ش��ϴ� url�� interceptor�� Ÿ�� �ʴ´�. 
		  ; }

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) { //�� ������ �ִ� �̹��������� �����ͼ� mapping�� �� �� �ֵ��� ����
			registry.addResourceHandler("/images/**") // �� URI�� /images/ ������ ���ϵ��� ��û�� ���
			        .addResourceLocations("/home/ec2-user/upload_images/"); // ���⿡ ����� ���ϵ��� ã�Ƽ� ������
		
		}	
	}