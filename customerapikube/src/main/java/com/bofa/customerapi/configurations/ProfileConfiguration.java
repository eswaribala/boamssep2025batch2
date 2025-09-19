package com.bofa.customerapi.configurations;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties
public class ProfileConfiguration {

    private String url;
    private String mysqlusername;
    private String mysqlpassword;
    private String driverClassName;
}
