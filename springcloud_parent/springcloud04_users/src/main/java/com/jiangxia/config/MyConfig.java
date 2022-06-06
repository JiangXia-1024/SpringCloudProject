package com.jiangxia.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiangxia
 * @date 2022年05月29日 13:36
 */
//表示这是一个springboot 配置类
@Configuration
public class MyConfig {

    @Bean
    @LoadBalanced //使其具有负载均衡属性
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
