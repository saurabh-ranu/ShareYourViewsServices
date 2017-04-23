package com.omnie.shareyourviewservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices11;


@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
	
	@Autowired
    private DefaultTokenServices11 tokenServices;
   
    private String resourceId="test";
    
   
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(resourceId).stateless(false)
        .tokenServices(tokenServices);
        
    }
    @Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.anonymous().disable()
		.requestMatchers().antMatchers("/PostHandle/**")
		.and().authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
		.antMatchers("/PostHandle/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
		.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler())
		;
	}

    
	  
}
