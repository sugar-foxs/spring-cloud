package com.gch.eurekaserver;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * guchunhui
 * 2019-05-30 20:44
 **/
public class MyBootStrapApplicationListener  implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        System.out.println("MyBootStrapApplicationListener");
    }
}
