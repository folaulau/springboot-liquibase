package com.lovemesomecoding.config;

import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import liquibase.integration.spring.SpringLiquibase;

// not working
@Configuration
public class GlobalConfig {
	
//	@LiquibaseDataSource
//	@Bean
//	public HikariDataSource dataSource() {
//
//		String username = "root";
//		String password = "";
//		String dbName = "spring_boot_liquibase";
//		String url = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
//
//		HikariConfig config = new HikariConfig();
//		config.setJdbcUrl(url);
//		config.setUsername(username);
//		config.setPassword(password);
//		config.addDataSourceProperty("cachePrepStmts", "true");
//		config.addDataSourceProperty("prepStmtCacheSize", "250");
//		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//		
//		HikariDataSource hds = new HikariDataSource(config);
//		hds.setMaximumPoolSize(30);
//		hds.setMinimumIdle(20);
//		hds.setMaxLifetime(1800000);
//		hds.setConnectionTimeout(30000);
//		hds.setIdleTimeout(600000);
//		
//		return hds;
//	}
//
//	@Bean
//	public SpringLiquibase liquibase() {
//	    SpringLiquibase liquibase = new SpringLiquibase();
//	    liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.yaml");
//	    liquibase.setDataSource(dataSource());
//	    return liquibase;
//	}
}
