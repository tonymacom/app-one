package com.tony.unit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.tony"})
public class AppOneApplication {
    public static void main( String[] args ) {

        SpringApplication.run(AppOneApplication.class,args);

    }
}
