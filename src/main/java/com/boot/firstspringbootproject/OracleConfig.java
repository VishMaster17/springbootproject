package com.boot.firstspringbootproject;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.boot.firstspringbootproject.model.Employee;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "oracleEntityManagerFactory", transactionManagerRef = "oracletransactionManager", basePackages = {
		"com.boot.firstspringbootproject.oradao" })
public class OracleConfig {

	@Primary
	@Bean(name = "oracleDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource oracleDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "oracleEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("oracleDataSource") DataSource oracleDataSource) {
		return builder.dataSource(oracleDataSource).packages(Employee.class).build();
	}

	@Primary
	@Bean(name = "oracletransactionManager")
	public PlatformTransactionManager oracletransactionManager(
			@Qualifier("oracleEntityManagerFactory") EntityManagerFactory oracleEntityManagerFactory) {
		return new JpaTransactionManager(oracleEntityManagerFactory);
	}

}
