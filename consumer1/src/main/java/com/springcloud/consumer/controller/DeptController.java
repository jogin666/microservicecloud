package com.springcloud.consumer.controller;


import com.springcloud.api.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController {

    //private static final String REST_URL_PREFIX = "http://localhost:8001";   //访问服务的地址
    private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";

    @GetMapping("/test")
    public String test(){
        return "this is test";
    }

    /**
    * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
    * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
    */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "consumer/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping(value = "consumer/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

    @RequestMapping(value = "consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
    }

}
