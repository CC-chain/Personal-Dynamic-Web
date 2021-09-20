package com.backend.source.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
@Getter
public class ApplicationProperties {

	private final DataSource datasource = new DataSource();
	
	private final Security security = new Security();
	
	@Getter
	@Setter
	public static class DataSource{
		private boolean cachePrepStmts = true;
		private int prepStmtCacheSize = 250;
		private int prepStmtCacheSqlLimit = 2048;
		private boolean useServerPrepStmts = true;
	}
	
	@Getter
	public static class Security {
			private final Jwt jwt = new Jwt();
			
			@Getter
			@Setter
			public static class Jwt{
				private String secret;
				private long tokenValidityInSeconds = 1800;
				private long tokenValidityInSecondsForRememberMe = 2592000;
			}
	}
}
