package com.springcloud.client4.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.api.entity.Dept;
import com.springcloud.client4.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get") //指定使用哪个方法处理微服务的熔断
    public Dept get(@PathVariable("id") Long id){
        Dept dept=service.get(id);
        if (dept==null){
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
    }

}
