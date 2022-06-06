package com.jiangxia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangxia
 * @date 2022年06月06日 19:45
 */
@RestController
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Value("${server.port}")
    private int port;

    @GetMapping("/product")
    public String product(){
        LOGGER.info("商品服务被调用.....");
        return "当前提供商品服务的端口是："+port;
    }
}
