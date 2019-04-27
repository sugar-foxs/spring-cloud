package com.gch.servicefeign.controller;

import com.gch.servicefeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * guchunhui
 * 2019-04-26 21:41
 **/
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return helloService.sayHiFromClientOne( name );
    }
}
