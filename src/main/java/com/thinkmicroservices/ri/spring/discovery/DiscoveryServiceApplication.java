package com.thinkmicroservices.ri.spring.discovery;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
@Slf4j
public class DiscoveryServiceApplication {

    @Value("${configuration.source:DEFAULT}")
    String configSource;
    @Value("${spring.application.name:NOT-SET}")
    private String serviceName;

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServiceApplication.class, args);
    }

    @PostConstruct
    private void displayInfo() {
        log.info("Service-Name:{}, configuration.source={}", serviceName, configSource);
    }
}
