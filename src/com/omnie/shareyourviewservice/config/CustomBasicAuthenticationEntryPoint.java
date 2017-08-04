package com.omnie.shareyourviewservice.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException authException) throws IOException, ServletException {
		System.out.println("In commence" + HttpMethod.OPTIONS.toString());
		if (request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.toString())) {
			System.out.println("In preflight request");
			response.setStatus(HttpServletResponse.SC_OK);
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "");
			response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization");
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");

			PrintWriter writer = response.getWriter();
			writer.println("HTTP Status 401 : " + authException.getMessage());
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("MY_TEST_REALM");
		super.afterPropertiesSet();
	}
}