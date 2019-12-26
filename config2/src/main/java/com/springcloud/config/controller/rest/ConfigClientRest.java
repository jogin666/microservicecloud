package com.springcloud.config.controller.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {

    /**
     * 3344微服务--->GitHub-->返回来的配置信息，
     */

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("eureka.client.server-url.defaultZone")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    /**
     * 访问地址：http://localhost:8203/config
     *  dev的端口是8201，test的端口是8203 (配置文件不同，端口就不一样！)
     * @return
     */
    @RequestMapping(value="/config",method = RequestMethod.GET)
    public String getConfig() {
        String str = "applicationName: " + applicationName + "\t eurekaServers:" + eurekaServers + "\t port: " + port;
        System.out.println("******str: " + str);
        return "applicationName: " + applicationName + "\t eurekaServers:" + eurekaServers + "\t port: " + port;
    }

}
