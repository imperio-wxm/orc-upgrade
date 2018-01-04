package com.wxmimperio.orc.common;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;


import javax.sql.DataSource;


@ConfigurationProperties(prefix = "spring.datasource")
public class HikariCPDataSourceConfig {

    @Bean
    public DataSource hikariDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.sqlite.JDBC");
        hikariConfig.setJdbcUrl("jdbc:sqlite:hello.db");
        return new HikariDataSource(hikariConfig);
    }
}
