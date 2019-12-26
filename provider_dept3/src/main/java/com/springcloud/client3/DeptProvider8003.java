package com.springcloud.client3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient //服务发现
public class DeptProvider8003 {

    public static void main(String args[]){
        SpringApplication.run(DeptProvider8003.class,args);
    }
}
