package com.omnie.shareyourviewservice.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		WebApplicationContext webAppContext = getAppContext();
		context.addListener(new ContextLoaderListener(webAppContext));
		context.addFilter("/",new CorsFilter());
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webAppContext);
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(Boolean.TRUE);
		ServletRegistration.Dynamic dispatcher = context.addServlet("DispatcherServlet", dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	
		
	}

	private WebApplicationContext getAppContext(){
		AnnotationConfigWebApplicationContext annotationContext = new AnnotationConfigWebApplicationContext();
		annotationContext.setConfigLocation("com.omnie.shareyourviewservice.config");
		
		return annotationContext;
	}

}
