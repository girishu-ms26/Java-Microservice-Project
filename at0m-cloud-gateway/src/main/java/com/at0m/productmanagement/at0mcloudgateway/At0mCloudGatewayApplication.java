package com.at0m.productmanagement.at0mcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class At0mCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(At0mCloudGatewayApplication.class, args);
    }

}
