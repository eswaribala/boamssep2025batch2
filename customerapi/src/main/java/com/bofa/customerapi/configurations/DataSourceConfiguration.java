package com.bofa.customerapi.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(ProfileConfiguration.class)
public class DataSourceConfiguration {
/*
    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${mysql_username}")
    private String userName;
    @Value("${password}")
    private String password;

 */

    private final ProfileConfiguration profileConfiguration;
    private DataSourceBuilder dataSourceBuilder;


    public DataSourceConfiguration(ProfileConfiguration _profileConfiguration) {
        this.profileConfiguration = _profileConfiguration;
    }
    @Bean
    public DataSource getDataSource() {

        dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(profileConfiguration.getDriverClassName())
                .url(profileConfiguration.getUrl())
                .username(profileConfiguration.getMysql_username())
                .password(profileConfiguration.getPassword());

        return dataSourceBuilder.build();
    }



}
