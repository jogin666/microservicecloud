package com.springcloud.eurekaclientconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
  EurekaServer服务器端启动类,接受其它微服务注册进来
*/
@EnableEurekaServer
@SpringBootApplication
public class ConfigGitEurekaServer7001 {

    public static void main(String args[]){
        SpringApplication.run(ConfigGitEurekaServer7001.class,args);
    }
}
