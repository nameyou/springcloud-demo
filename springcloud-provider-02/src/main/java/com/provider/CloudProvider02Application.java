package com.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudProvider02Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProvider02Application.class, args);
    }

}
