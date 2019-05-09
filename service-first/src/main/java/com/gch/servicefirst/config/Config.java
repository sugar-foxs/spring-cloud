package com.gch.servicefirst.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * guchunhui
 * 2019-04-27 17:22
 **/
@RefreshScope
@Configuration
public class Config {
    @Value("${bar}")
    public String bar;

    @Value("${base}")
    public String base;


    public String getBar() {
        return bar;
    }


    public String getBase() {
        return base;
    }
}
