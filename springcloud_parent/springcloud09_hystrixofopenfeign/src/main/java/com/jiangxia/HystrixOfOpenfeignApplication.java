package com.jiangxia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jiangxia
 * @date 2022年07月07日 21:20
 */
@SpringBootApplication
@EnableDiscoveryClient //开启服务客户端 consul server
@EnableFeignClients //开启openfeign调用
public class HystrixOfOpenfeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixOfOpenfeignApplication.class,args);
    }
}
