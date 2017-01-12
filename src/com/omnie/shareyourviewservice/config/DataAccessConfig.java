package com.omnie.shareyourviewservice.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

@Configuration
@PropertySource("file:E:/NeonWorkSpace/ShareYourViewsServices/src/jdbc.properties")
public class DataAccessConfig {
		
	@Value("${db.syvservices.driver}")
	private String driver;
	
	@Value("${db.syvservices.url}")
	private String url;
	
	@Value("${db.syvservices.username}")
	private String userName;
	
	@Value("${db.syvservices.password}")
	private String password;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
		PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
		
		return propertyConfigurer;
	}
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(driver);
	    dataSource.setUrl(url);
	    dataSource.setUsername(userName);
	    dataSource.setPassword(password);
	 
	    return dataSource;
	}
	
	@Autowired
	@Bean(name = "syvsessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	 
		
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addPackages("com.omnie.shareyourviewservice.hibermapping");
		sessionBuilder.addProperties(getHibernateProperties());
	    return sessionBuilder.buildSessionFactory();
	}
	
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    return properties;
	}
	

}
