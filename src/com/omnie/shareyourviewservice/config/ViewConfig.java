package com.omnie.shareyourviewservice.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.omnie.shareyourviewservice.beans.CategoryBean;
import com.omnie.shareyourviewservice.beans.CommentBean;
import com.omnie.shareyourviewservice.beans.PostBean;
import com.omnie.shareyourviewservice.beans.RoleBean;
import com.omnie.shareyourviewservice.beans.UserProfileBean;

@Configuration
public class ViewConfig {
	
	/*@Bean
	public ViewResolver contentResolver(ContentNegotiationManager negotiatingManager){
		ContentNegotiatingViewResolver contentResolver = new ContentNegotiatingViewResolver();
		contentResolver.setContentNegotiationManager(negotiatingManager);
		
		//List all the view resolvers
		List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
		viewResolvers.add(jsonViewResolver());
		viewResolvers.add(getMarshallingXmlViewResolver());
		contentResolver.setViewResolvers(viewResolvers);
		return contentResolver;
	}
	
	
	public ViewResolver jsonViewResolver(){
		return new ViewResolver() {
			
			@Override
			public View resolveViewName(String view, Locale locale) throws Exception {
				MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
				jsonView.setPrettyPrint(Boolean.TRUE);
				return jsonView;
			}
		};
		
	}
	
	
	@Bean(name = "marshallingXmlViewResolver")
	public ViewResolver getMarshallingXmlViewResolver() {
		
		// Define the classes to be marshalled - these must have @Xml... annotations on them
			return new ViewResolver() {
				
			@Override
			public View resolveViewName(String view, Locale locale) throws Exception {
				Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
				marshaller.setClassesToBeBound(CategoryBean.class,CommentBean.class,PostBean.class,RoleBean.class,UserProfileBean.class);
				MarshallingView xmlView = new MarshallingView();
				xmlView.setMarshaller(marshaller);
				return xmlView;
			}
		};
	}*/

}
