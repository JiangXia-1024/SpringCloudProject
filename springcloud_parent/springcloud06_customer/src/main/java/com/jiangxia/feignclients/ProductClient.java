package com.jiangxia.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

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
}
