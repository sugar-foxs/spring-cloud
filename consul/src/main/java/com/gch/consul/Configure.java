package com.gch.consul;

import com.ecwid.consul.v1.ConsulClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.cloud.consul.discovery.HeartbeatProperties;
import org.springframework.cloud.consul.discovery.TtlScheduler;
import org.springframework.cloud.consul.serviceregistry.ConsulServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * guchunhui
 * 2019-05-21 00:18
 **/
@Configuration
public class Configure {
    @Autowired(required = false)
    private TtlScheduler ttlScheduler;

    @Bean
    @Primary
    public ConsulServiceRegistry consulServiceRegistry(ConsulClient consulClient, ConsulDiscoveryProperties properties,
                                                       HeartbeatProperties heartbeatProperties) {
        return new MyConsulServiceRegistry(consulClient, properties, ttlScheduler, heartbeatProperties);
    }
}
