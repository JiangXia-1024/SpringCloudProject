package com.jiangxia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiangxia
 * @date 2022年05月27日 14:10
 */
@RestController
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    //服务注册与发现客户端对象
    @Autowired
    private DiscoveryClient discoveryClient;

    //负载均衡客户端对象
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("user")
    public String user(){
        logger.info("user module is running....");
//        在user服务中调用order服务，并且接受返回值
        //创建一个RestTemplate对象
//        RestTemplate restTemplate = new RestTemplate();
        //调用order接口
//        String result = restTemplate.getForObject("http://localhost:8084/order/order",String.class);

        //2、使用ribbon组件+resttemplate实现负载均衡调用，DiscoveryClient对象 loadbalanceClient @LoadBalance
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("orders");
//        serviceInstances.forEach(serviceInstance -> {
//            logger.info("服务主机：{};服务地址:{};服务端口：{}",serviceInstance.getHost(),serviceInstance.getUri(),serviceInstance.getPort());
//        });
//        logger.info("url:"+serviceInstances.get(0).getUri()+"/order/order");
//        String result = restTemplate.getForObject(serviceInstances.get(0).getUri()+"/order/order",String.class);
//        logger.info("使用DiscoveryClient对象调用order服务成功....",result);

        //3、使用loadbalancerclient进行服务调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("orders");
//        logger.info("服务主机：{};服务地址:{};服务端口：{}",serviceInstance.getHost(),serviceInstance.getUri(),serviceInstance.getPort());
//        String result = restTemplate.getForObject(serviceInstance.getUri()+"/order/order",String.class);
        //4、使用@loadbalance注解，作用：让对象具有ribbon负载均衡的属性
        //服务名+请求即可
        String result = restTemplate.getForObject("http://orders/order/order",String.class);
        return "user服务中调用order服务，结果为："+result;
    }
}
