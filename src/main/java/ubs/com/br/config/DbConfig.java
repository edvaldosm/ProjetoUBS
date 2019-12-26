package ubs.com.br.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DbConfig {
	@Autowired
	private DbConfigParam connParn;

	@Bean(name ="DSPostgres")
	    public DataSource getDataSource() {
	        @SuppressWarnings("rawtypes")
			DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.driverClassName(connParn.getDriver_class_name());
	        dataSourceBuilder.url(connParn.getUrl());
	        dataSourceBuilder.username(connParn.getUsername());
	        dataSourceBuilder.password(connParn.getPassword());
	        return dataSourceBuilder.build();
	    }
}
