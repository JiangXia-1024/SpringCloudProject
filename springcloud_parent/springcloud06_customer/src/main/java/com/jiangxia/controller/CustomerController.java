package com.jiangxia.controller;

import com.jiangxia.entity.Product;
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

    //测试调用product服务中的test接口，带请求参数
    @GetMapping("/customer1")
    public String customer1(String name,Integer age){
        LOGGER.info("消费服务正在调用");
        String product = productClient.test(name,age);
        return "消费服务正在调用;"+product;
    }

    //测试调用product服务中的test接口，带路径请求参数
    @GetMapping("/customer2")
    public String customer2(String name,Integer age){
        LOGGER.info("消费服务正在调用");
        String product = productClient.test1(name,age);
        return "消费服务正在调用;"+product;
    }

    @GetMapping("/customer3")
    public String customer3(){
        LOGGER.info("消费服务正在调用");
        String product = productClient.test2(new Product(1,20.33,"劫"));
        return "customer3正在调用消费服务  "+product;
    }


    /**
     * @author:江夏
     * @date 2022/6/15 21:18
     * @version 1.0
     * @description: 在使用数组类型参数时 也必须使用@requestparam注解标识
     */
    @GetMapping("/customer4")
    public String customer4(){
        LOGGER.info("消费服务正在调用");
        String product = productClient.test3(new String[]{"劫","亚索","刀妹"});
        return "customer3正在调用消费服务  "+product;
    }

    /**
     * @author:江夏
     * @date 2022/6/15 21:18
     * @version 1.0
     * @description: 在使用集合类型参数时 也必须使用@requestparam注解标识
     * 被调用方使用对象传值接受参数
     *
     * 服务提供者 使用vo对象
     *
     * 在openfeign调用中 使用@requestparams 数组的形式
     */
    @GetMapping("/customer5")
    public String customer5(){
        LOGGER.info("消费服务正在调用");
        String product = productClient.test4(new String[]{"劫","亚索","刀妹"});
        return "customer3正在调用消费服务  "+product;
    }

    @GetMapping("/customer6")
    public Product customer6(){
        LOGGER.info("消费服务正在调用");
        Product product = productClient.test5("亚索");
        return product;
    }

}
