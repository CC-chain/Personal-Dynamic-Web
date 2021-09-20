package com.backend.source.config;

import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

import com.zaxxer.hikari.HikariDataSource;

public class DatabaseConfig {

	privat final Logger log = LoggerFactory.getLogger(getClass());
	
	public HikariDataSource dataSource(DataSourceProperties dataSourceProperties , ApplicationProperties applicationProperties) {
		
	}
}
