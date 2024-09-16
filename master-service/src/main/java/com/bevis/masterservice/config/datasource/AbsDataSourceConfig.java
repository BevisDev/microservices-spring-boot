package com.bevis.masterservice.config.datasource;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public abstract class AbsDataSourceConfig {

    /**
     * Get information DataSource from config
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public abstract DataSourceProperties dataSourceProperties();

    /**
     * create DataSource
     *
     * @return DataSource
     */
    @Bean
    public DataSource dataSource() {
        DataSourceProperties properties = dataSourceProperties();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        return dataSource;
    }
}
