package com.omnie.shareyourviewservice.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.omnie.shareyourviewservice.beans.CategoryBean;
import com.omnie.shareyourviewservice.beans.CommentBean;
import com.omnie.shareyourviewservice.beans.PostBean;
import com.omnie.shareyourviewservice.beans.RoleBean;
import com.omnie.shareyourviewservice.beans.UserDetails;
import com.omnie.shareyourviewservice.beans.UserProfileBean;
import com.omnie.shareyourviewservice.utility.JaxbListWrapper;
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		
	}
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
                LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
                interceptor.setParamName("language");
                registry.addInterceptor(interceptor);
    }
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer
				.favorPathExtension(Boolean.TRUE)
				.favorParameter(Boolean.FALSE)
				.ignoreAcceptHeader(Boolean.TRUE)
				.useJaf(Boolean.FALSE)
				.defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("html", MediaType.TEXT_HTML)
				.mediaType("json", MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML)
				
				;
	}
	
	@Override
    public void configureMessageConverters(
      List<HttpMessageConverter<?>> converters) {
     
		converters.add(createXmlHttpMessageConverter());
		converters.add(new MappingJackson2HttpMessageConverter());
 
        super.configureMessageConverters(converters);
    }
    private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
        MarshallingHttpMessageConverter xmlConverter = 
          new MarshallingHttpMessageConverter();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(CategoryBean.class,CommentBean.class,PostBean.class,RoleBean.class,UserProfileBean.class,JaxbListWrapper.class,UserDetails.class);
        xmlConverter.setMarshaller(marshaller);
        return xmlConverter;
    }
	
	

	}
