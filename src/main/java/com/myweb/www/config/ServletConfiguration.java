package com.myweb.www.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = {"com.myweb.www.controller", "com.myweb.www.handler"})
public class ServletConfiguration implements WebMvcConfigurer  {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// resource 경로 설정, 파일 upload 경로 설정
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///D:\\_myweb\\_java\\fileUpload\\");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// prefix(WEB-INF/views) / sufiix(.jsp) 설정하기
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}
	
	//multipartResolver 설정 => file 업로드 할 때 사용
	@Bean(name="multipartResolver")
	public MultipartResolver getMultipartResolver() throws IOException{
		StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
		return multipartResolver;
	}
	

}
