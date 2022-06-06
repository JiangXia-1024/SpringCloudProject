package com.jiangxia.controller;

import com.jiangxia.feignclients.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangxia
 * @date 2022年06月06日 19:50
 */
@RestController
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private ProductClient productClient;

    @GetMapping("/customer")
    public String cutomer(){
        LOGGER.info("消费服务正在调用");
        String product = productClient.product();
        return "消费服务正在调用;"+product;
    }
}
