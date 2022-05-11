package com.adel.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class StudentAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		Class[] configFile = { StudentAppConfig.class };
		return configFile;
	}

	@Override
	protected String[] getServletMappings() {

		String[] Mappings = {"/"};
		return Mappings;
	}
}
