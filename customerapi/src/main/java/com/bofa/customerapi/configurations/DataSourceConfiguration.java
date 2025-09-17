package com.bofa.customerapi.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(VaultConfiguration.class)
public class DataSourceConfiguration {

    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${url}")
    private String url;


    private final VaultConfiguration vaultConfiguration;
    private DataSourceBuilder dataSourceBuilder;


    public DataSourceConfiguration(VaultConfiguration vaultConfiguration) {
        this.vaultConfiguration = vaultConfiguration;
    }
    @Bean
    public DataSource getDataSource() {

        dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName)
                .url(url)
                .username(vaultConfiguration.getMysqlusername())
                .password(vaultConfiguration.getMysqlpassword());

        return dataSourceBuilder.build();
    }



}
