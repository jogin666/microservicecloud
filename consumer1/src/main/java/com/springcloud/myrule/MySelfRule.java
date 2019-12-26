package com.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        //return new RandomRule();// Ribbon默认是轮询，自定义为随机
        //return new RoundRobinRule();// Ribbon默认是轮询，自定义为随机
        return new SelfRandomRule();
    }
}
