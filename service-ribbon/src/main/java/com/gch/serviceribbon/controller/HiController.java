package com.gch.serviceribbon.controller;

import com.gch.serviceribbon.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * guchunhui
 * 2019-04-26 21:22
 **/
@Slf4j
@RestController
public class HiController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name, HttpServletRequest request) {
        String res = helloService.hiService(name);
        log.info("--hi--"+res);
        log.info("TraceId={},spanId={}",request.getHeader("X-B3-TraceId"),request.getHeader("X-B3-SpanId"));
        return res;
    }
}
