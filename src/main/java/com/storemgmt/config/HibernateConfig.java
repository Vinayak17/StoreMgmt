package com.storemgmt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.EmptyInterceptor;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.storemgmt.util.AuditLogInterceptor;

@Configuration
@EnableTransactionManagement
@PropertySource(value =  {"classpath:application.properties"})
//ClassPath should be used and Never build the project along with the servlet jars since its provided by the container(Tomcat Server).Which results in conflict
public class HibernateConfig {

	@Autowired
	Environment environment;
	
	@Autowired
	private EmptyInterceptor auditLogInterceptor;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()
	{
		LocalSessionFactoryBean sessionBean = new LocalSessionFactoryBean();
		sessionBean.setDataSource(getDataSource());
		sessionBean.setPackagesToScan("com.storemgmt.model");
		sessionBean.setHibernateProperties(getHibernateProperties());
		return sessionBean;
	}
	
	@Bean
	public DataSource getDataSource(){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.userName"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}
	
	@Bean
	public Properties getHibernateProperties()
	{
		Properties prop = new Properties();
        prop.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        prop.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        prop.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        prop.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl"));
        return prop;
	}
	
	@Bean
	@Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       txManager.setEntityInterceptor(auditLogInterceptor);
       return txManager;
    }
}
