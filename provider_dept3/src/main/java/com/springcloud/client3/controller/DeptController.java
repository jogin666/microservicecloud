package com.springcloud.client3.controller;

import com.springcloud.api.entity.Dept;
import com.springcloud.client3.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;

    @Qualifier("discoveryClient")
    @Autowired
    private DiscoveryClient client;

    // 测试是否可以运行
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return"this is a test";
    }

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return service.saveDept(dept);
    }

    @RequestMapping(value = "dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        System.out.println("i am 8003");
        return service.findById(id);
    }

    @RequestMapping(value = "dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return service.findAll();
    }

    @RequestMapping(value = "/dept/discovery",method =RequestMethod.GET)
    public Object discovery(){
        List<String> list=client.getServices();
        System.out.println("**********" + list);
        List<ServiceInstance> instances = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance instance:instances){
            System.out.println(instance.getServiceId() + "\t" + instance.getHost()
                    + "\t" + instance.getPort() + "\t"
                    + instance.getUri());
        }
        return this.client;
    }
}
