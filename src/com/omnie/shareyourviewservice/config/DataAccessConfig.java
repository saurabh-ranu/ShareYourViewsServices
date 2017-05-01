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
@ComponentScan({ "com.omnie.shareyourviewservice.config" })
// @PropertySource("file:E:/NeonWorkSpace/ShareYourViewsServices/src/jdbc.properties")
public class DataAccessConfig {

	/*
	 * //@Value("${db.syvservices.driver}") private String driver;
	 * 
	 * //@Value("${db.syvservices.url}") private String url;
	 * 
	 * //@Value("${db.syvservices.username}") private String userName;
	 * 
	 * //@Value("${db.syvservices.password}") private String password;
	 */

	/*
	 * @Bean public static PropertySourcesPlaceholderConfigurer
	 * propertyConfigurer() { PropertySourcesPlaceholderConfigurer
	 * propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
	 * 
	 * return propertyConfigurer; }
	 */

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

	/**
	 * http://docs.spring.io/spring/docs/current/spring-framework-reference/html/orm.html#orm-resource-mngmnt
	 * Fortunately, Spring’s LocalSessionFactoryBean supports Hibernate’s
	 * SessionFactory.getCurrentSession() method for any Spring transaction
	 * strategy, returning the current Spring-managed transactional Session even
	 * with HibernateTransactionManager. Of course, the standard behavior of
	 * that method remains the return of the current Session associated with the
	 * ongoing JTA transaction, if any. This behavior applies regardless of
	 * whether you are using Spring’s JtaTransactionManager, EJB container
	 * managed transactions (CMTs), or JTA.
	 * 
	 * @param s
	 * @return
	 */

	@Autowired
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}

}
