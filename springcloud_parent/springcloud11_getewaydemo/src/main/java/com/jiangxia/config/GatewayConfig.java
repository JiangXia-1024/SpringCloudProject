package com.jiangxia.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiangxia
 * @date 2022年07月24日 16:42
 * desc:gateway配置文件
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator productRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                //商品路由
                .route("product_router",r->r.path("/product").uri("http://localhost:8087"))
                //客户路由
                .route("customer_router",r->r.path("/customer").uri("http://localhost:8085"))
                .build();
    }
}
