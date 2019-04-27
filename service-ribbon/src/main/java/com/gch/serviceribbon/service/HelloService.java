package com.gch.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * guchunhui
 * 2019-04-26 21:21
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-FIRST/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
