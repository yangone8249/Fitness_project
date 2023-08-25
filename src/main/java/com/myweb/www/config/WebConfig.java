package com.myweb.www.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {RootConfig.class, SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] {ServletConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		// encoding filter 설정
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("utf-8");
		encodingFilter.setForceEncoding(true); //Force는 외부로 나가는 인코딩 설정
		return new Filter[] {encodingFilter};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		// 커스터마이징 레지스터 => 파일첨부 업로드 설정할 때 사용
		// throwExecptionIfNotHandlerFound : 존재하지 않는 API응답에 대한 커스터마이징이다.
		registration.setInitParameter("throwExecptionIfNotHandlerFound", "true");
		
		//파일 첨부
		String uploadLocation = "D:\\_myweb\\_java\\fileUpload"; //업로드 경로
		int maxFileSize = 1024*1024*2; //2MB
		int maxrReqSize = maxFileSize * 5; //파일 요청 최대 크기 (10MB)
		int fileSizeThreshold = maxFileSize; // 파일전송 시 만들어지는 임시공간
				
		registration.setMultipartConfig(new MultipartConfigElement(uploadLocation, maxFileSize, maxrReqSize, fileSizeThreshold));
	}
	
	

}
