package com.springcloud.consumer2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
//指定熔断处理类所在的包
@EnableFeignClients(basePackages = {"com.springcloud.api"})
//包扫描
@ComponentScan("com.springcloud.api")
public class DeptConsumer_2_80 {

    public static void main(String args[]){
        SpringApplication.run(DeptConsumer_2_80.class,args);
    }
}
