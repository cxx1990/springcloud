package com.cxx.config;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class EnvController {


    @PostMapping("/monitor1")
    public void monitor() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        String url = "http://pwp6ai.natappfree.cc/actuator/bus-refresh";
        HttpPost httpPost = new HttpPost(url);
        // 设置请求的header
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        // 执行请求
        try {
            HttpResponse response = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}