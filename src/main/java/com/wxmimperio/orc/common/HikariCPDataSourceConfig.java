package com.wxmimperio.orc.common;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "spring.datasource")
@Component
public class HikariCPDataSourceConfig {

    @Bean
    public DataSource hikariDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.sqlite.JDBC");
        hikariConfig.setJdbcUrl("jdbc:sqlite:sequenceToOrc.db");
        return new HikariDataSource(hikariConfig);
    }
}
