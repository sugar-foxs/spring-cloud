package com.gch.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * guchunhui
 * 2019-04-26 22:24
 **/
@Component
public class ServiceHiHystric implements HelloService{

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry," + name;
    }
}
