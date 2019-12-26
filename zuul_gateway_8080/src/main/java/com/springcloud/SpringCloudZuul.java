package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy  //网关代理
public class SpringCloudZuul {

    public static void main(String args[]){
        SpringApplication.run(SpringCloudZuul.class,args);
    }
}
