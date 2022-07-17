package com.jiangxia.controller;

import com.jiangxia.feignclients.HystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangxia
 * @date 2022年07月09日 18:04
 */
@RestController
public class TestHystrixController {

    @Autowired
    //注入openfeign的客户端
    private HystrixClient hystrixClient;

    @GetMapping("/demo")
    public String test(Integer id){
        System.out.println("test ok");
        String demoResult = hystrixClient.demo(id);
        System.out.println("demo result:"+demoResult);
        return "test ok";
    }
}
