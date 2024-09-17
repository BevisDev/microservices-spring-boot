// package com.bevis.masterservice.config.datasource;
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
// import javax.sql.DataSource;
//
// @Configuration
// public abstract class AbsDataSourceConfig {
//
////    /**
////     * Get information DataSource from config
////     */
////    @Bean
////    @ConfigurationProperties(prefix = "spring.datasource")
////    public abstract DataSourceProperties dataSourceProperties();
//
//    /**
//     * create DataSource
//     *
//     * @return DataSource
//     */
//    @Bean
//    public DataSource dataSource() {
//        DataSourceProperties properties = new DataSourceProperties();
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl(properties.getUrl());
//        dataSource.setUsername(properties.getUsername());
//        dataSource.setPassword(properties.getPassword());
//        return dataSource;
//    }
// }
