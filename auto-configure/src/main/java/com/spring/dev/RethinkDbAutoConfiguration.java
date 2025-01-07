package com.spring.dev;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.rethinkdb.RethinkDB;

@ConfigurationProperties(prefix = "rethinkdb")
record RethinkDbProperties(String host,int port) {
	
}

@AutoConfiguration
@EnableConfigurationProperties
public class RethinkDbAutoConfiguration {
	
	@ConditionalOnMissingBean({RethinkDbConnectionDetails.class})
	RethinkDbConnectionDetails rethinkDbConnectionDetails(RethinkDbProperties prpoerties) {
		return new RethinkDbPropertiesConnectionDetails(prpoerties);
	}
	
	static class RethinkDbPropertiesConnectionDetails implements RethinkDbConnectionDetails{
		
		private final RethinkDbProperties rethinkDbProperties;
		
		public RethinkDbPropertiesConnectionDetails(RethinkDbProperties rethinkDbProperties) {
			this.rethinkDbProperties = rethinkDbProperties;
		}

		@Override
		public String host() {
			return this.rethinkDbProperties.host();
		}

		@Override
		public int port() {
			return this.rethinkDbProperties.port();
		}
	}
	
	@Bean
	RethinkDB rethinkDB() {
		return RethinkDB.r;
	}
	
	@Bean
	com.rethinkdb.net.Connection rethinkDbConnection(RethinkDB rethinkDB,
			RethinkDbConnectionDetails connectionDetails){
		
		return rethinkDB
				.connection()
				.hostname(connectionDetails.host())
				.port(connectionDetails.port())
				.connect();
		
	}
	
	

}
