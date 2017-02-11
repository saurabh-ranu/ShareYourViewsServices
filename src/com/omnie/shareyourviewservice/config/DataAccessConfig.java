package com.omnie.shareyourviewservice.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.omnie.shareyourviewservice.config"})
//@PropertySource("file:E:/NeonWorkSpace/ShareYourViewsServices/src/jdbc.properties")
public class DataAccessConfig {
		
	/*//@Value("${db.syvservices.driver}")
	private String driver;
	
	//@Value("${db.syvservices.url}")
	private String url;
	
	//@Value("${db.syvservices.username}")
	private String userName;
	
	//@Value("${db.syvservices.password}")
	private String password;*/
	
	/*@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
		PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
		
		return propertyConfigurer;
	}*/
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/shareyourviewdb");
	    dataSource.setUsername("root");
	    dataSource.setPassword("root");
	 
	    return dataSource;
	}
	
	@Autowired
	@Bean(name = "syvsessionFactory")
	 public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(getDataSource());
	        sessionFactory.setPackagesToScan(new String[] { "com.omnie.shareyourviewservice.hibermapping" });
	        sessionFactory.setHibernateProperties(getHibernateProperties());
	        System.out.println(sessionFactory);
	        return sessionFactory;
	     } 
	
	
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    return properties;
	}
	
	@Autowired
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
	

}
