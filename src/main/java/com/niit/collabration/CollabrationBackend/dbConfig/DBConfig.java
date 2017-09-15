package com.niit.collabration.CollabrationBackend.dbConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collabration.CollabrationBackend.dao.BlogDAO;
import com.niit.collabration.CollabrationBackend.dao.BlogDAOImpl;

@Configuration
@ComponentScan("com.niit.collabration.CollabrationBackend")
@EnableTransactionManagement
public class DBConfig {
	
	public DataSource getOracleDataSource()
	{
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver"); 
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE"); 
		driverManagerDataSource.setUsername("System");
		driverManagerDataSource.setPassword("user");
		return 	driverManagerDataSource;
		
		
	}
	
	public Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle11gDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	

    
    @Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
    	LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getOracleDataSource());
    	localSessionFactoryBuilder.addProperties(getHibernateProperties());
    	System.out.println("........sessionfactory bean is created.......... ");
    	return localSessionFactoryBuilder.buildSessionFactory();
    	 
	}
    @Autowired
    @Bean(name="transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
    {
    	System.out.println("--Transaction manager Object Creation--");
    	HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
    	System.out.println("--Transaction manager Object Created--");
    	return transactionManager;
    }
    
    @Bean
    public BlogDAO getBlogDAO(SessionFactory sessionFactory)
    {
    	return new BlogDAOImpl(sessionFactory);
    }


}
