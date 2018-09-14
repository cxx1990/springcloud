package com.cxx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EnvController {

   /* @Autowired
    private LoadBalancerClient balancerClient;

    @PostMapping("/monitor")
    public String monitor() {
        ServiceInstance user = balancerClient.choose("CONFIG");
        String url = String.format("http://%s:%s",user.getHost(),user.getPort()+"/actuator/bus-refresh");
        return HttpClientUtil.post(url);
    }*/
}