package com.springcloud.api.service;

import com.springcloud.api.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*
* value 指定调用注册中心中的具体服务
* fallbackFactory--->熔断器的降级操作
* */
@FeignClient(value = "MICROSERVICECLOUND-DEPT",
        fallbackFactory =DeptClientServiceFallbackFactory.class )
public interface DeptClientService {

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    List<Dept> list();

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    boolean add(Dept dept);
}
