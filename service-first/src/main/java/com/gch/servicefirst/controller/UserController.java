package com.gch.servicefirst.controller;

import com.gch.servicefirst.config.Config;
import com.gch.servicefirst.config.IpConfiguration;
import com.gch.servicefirst.meta.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.List;

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
    public List<User> home(@RequestParam(value = "name", defaultValue = "gch") String name) {
        List<User> res = new ArrayList<>();
        res.add(new User(1,ipConfiguration.getPort()+"base:"+config.getBase()));
        res.add(new User(2,ipConfiguration.getPort()+"bar:"+config.getBar()));

        return res;
    }
}
