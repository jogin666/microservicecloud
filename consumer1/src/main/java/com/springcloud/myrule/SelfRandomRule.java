package com.springcloud.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SelfRandomRule extends AbstractLoadBalancerRule {

    private int total=0;  //被调用的次数
    private int currIndex=0;  //记录是第几个服务器


    public Server choose(ILoadBalancer ilb,Object key){  //采用轮询法
        if (ilb==null){
            return null;
        }
        Server server=null;
        while (server==null){
            if (Thread.interrupted()){
                return null;
            }
            List<Server> upList=ilb.getReachableServers(); //可使用的服务器
            List<Server> allList = ilb.getAllServers(); //全部服务器
            int serverCount=allList.size();
            if (serverCount==0){ //没有服务器
                return null;
            }
            if (total<5){  //要求每台服务器被调用5次
                server=upList.get(currIndex);
                total++;
            }else{
                total=0; //重新计数
                currIndex++; //下一台服务器
                if (currIndex>=upList.size()){
                    currIndex=0;
                }
            }
            if (server==null){  //获取不到服务器，让出时间片
                Thread.yield();
                continue;
            }
            if (server.isAlive()){ //判断服务器是否仍可用
                return server;
            }
            //服务失效，让出时间片
            server=null;
            Thread.yield();
        }
        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        //TODO Auto-generated method stub
    }

    @Override
    public Server choose(Object o) {
        return choose(getLoadBalancer(),o);
    }
}
