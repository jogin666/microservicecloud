package com.springcloud.consumer3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer3 {

    /**
     * 访问地址: http://localhost:9001/hystrix
     * 监控地址：http://localhost:8001/hystrix.stream
     */
    public static void main(String args[]){
        SpringApplication.run(DeptConsumer3.class,args);
    }
}
