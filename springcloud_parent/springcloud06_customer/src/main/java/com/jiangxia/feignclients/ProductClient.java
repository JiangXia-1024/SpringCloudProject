package com.jiangxia.feignclients;

import com.jiangxia.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author jiangxia
 * @date 2022年06月06日 20:05
 * desc:customer项目中具体调用product服务的接口
 */
@FeignClient(value="product")//调用某个具体服务，value值为需要调用的服务的服务名
public interface ProductClient {

    //调用商品服务的接口
    @GetMapping("/product")
    String product();

    //调用product服务的test接口,带有参数 querystring
    @GetMapping("/test")
    String test(@RequestParam() String name, @RequestParam() Integer age);

    //调用product服务的test接口,带有参数 路径参数
    @GetMapping("/test1/{name}/{age}")
    String test1(@PathVariable("name") String name,@PathVariable("age") Integer age);

    //调用product服务中test2接口并传递对象
    @PostMapping("/test2")
    String test2(@RequestBody Product product);

    //调用test3接口 接收数组类型参数
    @GetMapping("/test3")
    String test3(@RequestParam("names") String[] names);

    //调用test4，接受集合类型的参数
    // ?names=zhansan&names=lisi
    //所以这里也是使用@requestparams注解
    @GetMapping("/test4")
    String test4(@RequestParam("names") String[] names);

    @GetMapping("/product/{name}")
    Product test5(@PathVariable("name") String name);
}
