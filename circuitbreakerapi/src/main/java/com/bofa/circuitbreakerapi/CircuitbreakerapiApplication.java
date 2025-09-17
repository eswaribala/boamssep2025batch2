package com.bofa.circuitbreakerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class CircuitbreakerapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircuitbreakerapiApplication.class, args);
    }


    @Bean
    public RestClient getRestClient() {
        return RestClient.create();
    }
}
