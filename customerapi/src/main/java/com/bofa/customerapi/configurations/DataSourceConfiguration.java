package com.bofa.customerapi.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Value("${driver-class-name}")
    private String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${mysql_username}")
    private String userName;
    @Value("${password}")
    private String password;

    private DataSourceBuilder dataSourceBuilder;

    @Bean
    public DataSource getDataSource() {

        dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName)
                .url(url)
                .username(userName)
                .password(password);

        return dataSourceBuilder.build();
    }



}
