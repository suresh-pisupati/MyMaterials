package com.suresh.ivs.database.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.suresh.ivs.database.entities.VersionEntity;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.suresh.ivs.repository", entityManagerFactoryRef = "ivsEntityManager", transactionManagerRef = "ivsTransactionManager")
public class IVSPersistenceConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource ivsDataSource() {

		return DataSourceBuilder.create().build();
	}

	@Bean(name = "ivsEntityManager")
	public LocalContainerEntityManagerFactoryBean businessRulesEntityManagerFactory(
			EntityManagerFactoryBuilder builder) {

		return builder.dataSource(ivsDataSource()).properties(applicationProperties()).packages(VersionEntity.class)
				.persistenceUnit("versionPU").build();
	}

	@Bean(name = "ivsTransactionManager")
	public PlatformTransactionManager businessRulesTransactionManager(
			@Qualifier("ivsEntityManager") EntityManagerFactory entityManagerFactory) {

		return new JpaTransactionManager(entityManagerFactory);
	}

	private Map applicationProperties() {

		Resource resource = new ClassPathResource("application.properties");

		try {
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			System.out.println("key:   " + properties);
			return properties.entrySet().stream()
					.collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue()));
		} catch (IOException e) {
			return new HashMap();
		}
	}
}
