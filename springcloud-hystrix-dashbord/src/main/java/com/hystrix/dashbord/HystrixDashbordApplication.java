package com.hystrix.dashbord;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@EnableHystrix
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashbordApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashbordApplication.class, args);
    }
}
