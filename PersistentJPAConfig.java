package com.suresh.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//This annotation indicates that a class contains one or more @Bean beans
//(java classes) to be processed by container to generate bean definitions at runtime.
//We can still use @Bean without annotating class with @Configuration. In this mode
//we cannot use other features like @Import, @ComponentScan, @PropertyResource etc...
@Configuration

//This annotation enables spring's annotation-driven transaction management capability
@EnableTransactionManagement

//In order to let spring container to know which data sources refer to which repository, we
//use this annotation.
//For each jpa data source, we need to define a configuration
@EnableJpaRepositories(entityManagerFactoryRef = "oipaEntityManager", transactionManagerRef = "oipaTransactionManager", basePackages = {
		"org.springdemo.multiple.datasources.repository.domains" })

//This annotation is used to define the path for the properties file
@PropertySource({ "classpath:database.properties" })

//This annotation is used to define the scope of this class. Default scope is singleton
@Scope("singleton")
public class PersistentJPAConfig {

	@Autowired
	private Environment env;

	@Qualifier("datasource")
	@Autowired
	private DataSource dataSource;

	@Bean(name = "oipaTransactionManager")
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	/**
	 * This takes care of setting the data sources, setting the persistence
	 * providers etc...
	 * 
	 * @return
	 */
	@Primary
	@Bean(name = "oipaEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan("YOUR.PACKAGE.NAME");
		entityManagerFactoryBean.setJpaProperties(hibProperties());

		return entityManagerFactoryBean;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}
}
