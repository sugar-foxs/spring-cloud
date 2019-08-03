package com.gch.eurekaserver;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * guchunhui
 * 2019-05-30 20:45
 **/
@Component
public class MyCommandRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyCommandRunner");
    }
}
