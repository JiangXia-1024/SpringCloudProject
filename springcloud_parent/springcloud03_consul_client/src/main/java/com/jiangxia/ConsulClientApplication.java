package com.jiangxia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jiangxia
 * @date 2022年05月24日 14:07
 */
@SpringBootApplication
@EnableDiscoveryClient //代表这是服务注册中心的一个客户端，通用的服务注册注解 可以表示consul、zk、nacos 具体根据导入的依赖判断
public class ConsulClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulClientApplication.class,args);
    }
}
