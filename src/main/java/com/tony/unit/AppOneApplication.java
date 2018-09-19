package com.tony.unit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppOneApplication {
    public static void main( String[] args ) {

        SpringApplication.run(AppOneApplication.class,args);

    }
}
