package com.jiangxia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author jiangxia
 * @date 2022年07月17日 13:34
 */
@SpringBootApplication
//@EnableDiscoveryClient //默认只要引入DiscoveryClient 依赖，该注解无需显示声明 自动注册
@EnableHystrixDashboard //这个注解作用用来开启当前应用为仪表盘应用
public class BashBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(BashBoardApplication.class,args);
    }
}
