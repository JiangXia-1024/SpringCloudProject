package com.jiangxia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jiangxia
 * @date 2022年05月19日 14:32
 */
@SpringBootApplication
//当前应用作为一个客户端进行服务注册
@EnableEurekaClient
public class SpringCloudEurekaClient {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClient.class,args);
    }
}
