package com.jiangxia.feignclients;

import org.springframework.context.annotation.Configuration;

/**
 * @author jiangxia
 * @date 2022年07月09日 21:08
 * desc：自定义的处理方式
 */
@Configuration
public class HystrixClientFallBack implements HystrixClient {
    @Override
    public String demo(Integer id) {
        return "当前服务忙，请稍后再试！";
    }
}
