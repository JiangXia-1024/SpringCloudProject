package com.jiangxia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jiangxia
 * @date 2022年06月06日 19:26
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients//开启openfeign客户端调用
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class,args);
    }
}
