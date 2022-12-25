package com.at0m.productmanagement;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.at0m"})
@EnableSwagger2
@EnableFeignClients(basePackages = "com.at0m")
@EnableEurekaClient
public class GetAvailableQuantityApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetAvailableQuantityApiApplication.class, args);
	}

}
