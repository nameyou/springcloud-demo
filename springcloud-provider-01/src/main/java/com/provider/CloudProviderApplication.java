package com.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.provider.mapper")
@SpringBootApplication
@EnableEurekaClient // 服务提供者
//@EnableDiscoveryClient // 服务发现 暴露一个接口可以获取注册中心中注册的服务
public class CloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderApplication.class, args);
    }

}
