package com.springcloud.consumer2.controller;

import com.springcloud.api.entity.Dept;
import com.springcloud.api.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired  //DeptService 已指定了熔断模式
    private DeptClientService service;

    @RequestMapping("/test")
    public String test(){
         return "this is a test";
    }

    @RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return this.service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
    public List<Dept> list() {
        return this.service.list();
    }

    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public Object add(Dept dept) {
        return this.service.add(dept);
    }
}
