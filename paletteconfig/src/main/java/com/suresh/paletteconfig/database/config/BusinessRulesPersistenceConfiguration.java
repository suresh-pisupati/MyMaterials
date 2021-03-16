package com.suresh.paletteconfig.database.config;

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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.suresh.paletteconfig.entities.BusinessRulesEntity;

/**
 * In order to connect to multiple databases, we need to have a configuration class which creates
 * entity manager and persistent units using the transaction manager. The class has to be annotated
 * with <blockingquote>
 * 
 * <pre>
 * <b>
 * &#64;Configuration
 * &#64;EnableTransactionManagement
 * &#64;EnableJpaRepositories
 * </b>
 * </pre>
 * 
 * </blockingquote> While configuring multiple databases one database should be made as primary
 * database and this can be done using <b>@Primary</b> tag. Failing to annotate with the @Primary
 * tag will results in server start failure with the following cause: <blockingquote>
 * 
 * <pre>
Description:
 
Parameter 0 of method businessRulesEntityManagerFactory in com.suresh.paletteconfig.database.config.BusinessRulesPersistenceConfiguration required a bean of type 'org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder' that could not be found.
Action:
Consider defining a bean of type 'org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder' in your configuration.
 * </pre>
 * 
 * </blockingquote>
 * 
 * @author pksuresh
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.suresh.paletteconfig.repository", entityManagerFactoryRef = "businessRulesEntityManager", transactionManagerRef = "businessRulesTransactionManager")
public class BusinessRulesPersistenceConfiguration {

   /**
    * @ConfigurationProperties will define to which data source configuration we need to connect
    * @return datasource to which we need to connect
    */
   @Primary
   @Bean
   @ConfigurationProperties(prefix = "spring.datasource")
   public DataSource oipaDataSource() {

      return DataSourceBuilder.create().build();
   }

   @Primary
   @Bean(name = "businessRulesEntityManager")
   public LocalContainerEntityManagerFactoryBean businessRulesEntityManagerFactory( EntityManagerFactoryBuilder builder ) {

      return builder.dataSource( oipaDataSource() ).properties( hibernateProperties() ).packages( BusinessRulesEntity.class ).persistenceUnit( "businessRulesPU" ).build();
   }

   @Primary
   @Bean(name = "businessRulesTransactionManager")
   public PlatformTransactionManager businessRulesTransactionManager( @Qualifier("businessRulesEntityManager") EntityManagerFactory entityManagerFactory ) {

      return new JpaTransactionManager( entityManagerFactory );
   }

   private Map hibernateProperties() {

      Resource resource = new ClassPathResource( "application.properties" );

      try {
         Properties properties = PropertiesLoaderUtils.loadProperties( resource );

         return properties.entrySet().stream().collect( Collectors.toMap( e -> e.getKey().toString(), e -> e.getValue() ) );
      }
      catch( IOException e ) {
         return new HashMap();
      }
   }
}
