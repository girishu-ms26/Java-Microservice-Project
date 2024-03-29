package com.at0m.productmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class At0mConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(At0mConfigServerApplication.class, args);
	}

}
