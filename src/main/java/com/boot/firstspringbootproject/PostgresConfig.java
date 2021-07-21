package com.boot.firstspringbootproject;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.boot.firstspringbootproject.model.Employee;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "postgresEntityManagerFactory", transactionManagerRef = "postgrestransactionManager", basePackages = {
		"com.boot.firstspringbootproject.postdao" })
public class PostgresConfig {

	@Bean(name = "postgresDataSource")
	@ConfigurationProperties(prefix = "spring.second-datasource")
	public DataSource postgresDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "postgresEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("postgresDataSource") DataSource postgresDataSource) {
		return builder.dataSource(postgresDataSource).packages(Employee.class).build();
	}

	@Bean(name = "postgrestransactionManager")
	public PlatformTransactionManager postgrestransactionManager(
			@Qualifier("postgresEntityManagerFactory") EntityManagerFactory postgresEntityManagerFactory) {
		return new JpaTransactionManager(postgresEntityManagerFactory);
	}

}
