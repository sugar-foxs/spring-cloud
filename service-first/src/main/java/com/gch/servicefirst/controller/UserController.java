package com.gch.servicefirst.controller;

import com.gch.servicefirst.config.Config;
import com.gch.servicefirst.config.IpConfiguration;
import com.gch.servicefirst.meta.po.User;
import com.gch.servicefirst.meta.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guchunhui
 * 2019-04-26 21:05
 **/
@Slf4j
@RestController
@RefreshScope
public class UserController {
    @Autowired
    private IpConfiguration ipConfiguration;

    @Autowired
    private Config config;

    @Autowired
    private Mapper dozerMapper;

    @RequestMapping("/hi")
    public List<User> home(@RequestParam(value = "name", defaultValue = "gch") String name, HttpServletRequest request) {
        log.info("TraceId={},spanId={}",request.getHeader("X-B3-TraceId"),request.getHeader("X-B3-SpanId"));

        List<User> res = new ArrayList<>();
        User user = new User(1,ipConfiguration.getPort()+",base:"+config.getBase());
        res.add(user);
        res.add(new User(2,ipConfiguration.getPort()+",bar:"+config.getBar()));
        log.info("userVo:{}", dozerMapper.map(user, UserVo.class));
        log.info("result:{}",res);
        return res;
    }
}
