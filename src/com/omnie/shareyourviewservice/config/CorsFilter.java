package com.omnie.shareyourviewservice.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
 
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
 
/*
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
            // CORS "pre-flight" request
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.addHeader("Access-Control-Max-Age", "1800");//30 min
            response.setHeader("Access-Control-Allow-Headers", "origin,content-type");
        }
        filterChain.doFilter(request, response);
    }*/

@Override
public void destroy() {
	// TODO Auto-generated method stub
	
}

@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	System.out.println("In Cors do filter");
	HttpServletResponse response = (HttpServletResponse) res;
	HttpServletRequest request = (HttpServletRequest) req;
	System.out.println("In Cors do filter method"+request.getMethod());
	response.setHeader("Access-Control-Allow-Origin", "*");
	response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
	response.setHeader("Access-Control-Max-Age", "3600");
	response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Access-Control-Allow-Headers");
	if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
		System.out.println("In Cors do filter method111"+request.getMethod());
		response.setStatus(HttpServletResponse.SC_OK);
    } else {
        chain.doFilter(req, res);
    }
	
}

@Override
public void init(FilterConfig arg0) throws ServletException {
	// TODO Auto-generated method stub
	
}
}
