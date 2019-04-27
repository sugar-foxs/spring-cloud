package com.gch.servicefirst.controller;

import com.gch.servicefirst.config.Config;
import com.gch.servicefirst.config.IpConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.Configuration;

/**
 * guchunhui
 * 2019-04-26 21:05
 **/
@RestController
@RefreshScope
public class UserController {
    @Autowired
    private IpConfiguration ipConfiguration;

    @Autowired
    private Config config;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "gch") String name) {
        return "hi " + name + " ,i am from port:" + ipConfiguration.getPort()
                + "bar:" + config.getBar()
                ;
    }
}
