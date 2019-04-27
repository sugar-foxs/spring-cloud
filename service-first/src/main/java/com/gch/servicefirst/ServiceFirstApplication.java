package com.gch.servicefirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceFirstApplication.class, args);
    }

}
