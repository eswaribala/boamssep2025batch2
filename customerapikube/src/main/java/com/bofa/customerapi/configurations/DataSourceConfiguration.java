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



    private final ProfileConfiguration  profileConfiguration;
    private DataSourceBuilder dataSourceBuilder;


    public DataSourceConfiguration(ProfileConfiguration profileConfiguration) {
        this.profileConfiguration = profileConfiguration;
    }
    @Bean
    public DataSource getDataSource() {

        dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(profileConfiguration.getDriverClassName())
                .url(profileConfiguration.getUrl())
                .username(profileConfiguration.getMysqlusername())
                .password(profileConfiguration.getMysqlpassword());

        return dataSourceBuilder.build();
    }



}
