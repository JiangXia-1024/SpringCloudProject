package com.jiangxia.controller;

import com.jiangxia.entity.Product;
import com.jiangxia.entity.vos.CollectionVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @author:江夏
     * @date 2022/6/7 20:50
     * @version 1.0
     * @description: 定义一个接受零散类型参数的接口 querystring
     */
    @GetMapping("/test")
    public String test(String name,Integer age){
        LOGGER.info("name:{}  age:{}",name,age);
        return "当前调用的是test接口，参数为：name:"+name+";age:"+age;
    }

    /**
     * @author:江夏
     * @date 2022/6/9 17:51
     * @version 1.0
     * @description: 路径传参
     */
    @GetMapping("/test1/{name}/{age}")
    public String test1(@PathVariable("name") String name, @PathVariable("age")Integer age){
        LOGGER.info("name:{}  age:{}",name,age);
        return "当前调用的是test1接口，参数为：name:"+name+";age:"+age;
    }

    /**
     * @author:江夏
     * @date 2022/6/9 17:51
     * @version 1.0
     * @description: 对象类型参数
     */
    @PostMapping("/test2")
    public String test2(@RequestBody Product product){
        LOGGER.info("product:{}",product);
        return "当前调用的是test2接口，参数为：product:"+product;
    }

    /**
     * @author:江夏
     * @date 2022/6/10 14:27
     * @version 1.0
     * @description: 接受数组类型参数的接口
     */
    @GetMapping("/test3")
    public String test3(String[] names){
        for (String name:names) {
            LOGGER.info("name is {}",name);
        }
        return "test3接口正在被调用，端口是："+port;
    }

    /**
     * @author:江夏
     * @date 2022/6/15 21:32
     * @version 1.0
     * @description: 接受集合类型参数
     * 注意：springmvc不能直接接受集合类型参数，如果想要接受集合类型参数
     * 必须将集合放到对象中，使用对象的方式接受
     *  oo：面向对象
     *  vo：值对象：用来传递数据对象
     *  dto：数据传输对象data transfer object
     */
    @GetMapping("/test4")
//    public String test4(List<String> names){
    //需要改成用vo对象接收
    public String test4(CollectionVO collectionVO){
        collectionVO.getNames().forEach(name->LOGGER.info("name is {}",name));
        return "test4接口正在被调用，端口是："+port;
    }


}
