package com.gch.consul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * guchunhui
 * 2019-05-20 23:53
 **/
@RestController
public class HealthController {

    @RequestMapping("/health")
    public String health(){
        return "ok";
    }
}
