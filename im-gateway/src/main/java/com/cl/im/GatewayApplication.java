package com.cl.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cl.im")
@SpringBootApplication
public class GatewayApplication {
    public static void main( String[] args ) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
