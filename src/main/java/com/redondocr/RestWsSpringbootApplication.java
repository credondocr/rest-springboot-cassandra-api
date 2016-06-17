package com.redondocr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan
@Configuration
@EnableCassandraRepositories(basePackages = { "com.redondocr.domain" } )
public class RestWsSpringbootApplication extends AbstractCassandraConfiguration {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(RestWsSpringbootApplication.class, args);
	}

	@Bean
	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(environment.getProperty("cassandra.contactpoints"));
		cluster.setPort(Integer.parseInt(environment.getProperty("cassandra.port")));
		return cluster;
	}

	@Override
	protected String getKeyspaceName() {
		return environment.getProperty("cassandra.keyspace-name");
	}

	@Bean
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
		return new BasicCassandraMappingContext();
	}


	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.NONE;
	}


}
