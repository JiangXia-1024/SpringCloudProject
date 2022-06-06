package com.jiangxia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangxia
 * @date 2022年05月27日 14:08
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Value("${server.port}")
    private int port;

    private static  final Logger  logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("order")
    public String order(){
        logger.info("order module is running....");
        return "order module is running,and this port is "+ port;
    }
}
