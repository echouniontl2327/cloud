package com.mou.service.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mou on 2017/11/14.
 *
 * @author Mou
 * @date 2017/11/14
 * @since 1.0
 */
@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 通过注解HystrixCommand 引入熔断机制，当服务不能范围的时候会调用fallbackMethod里面注释的方法名
     * @return
     */
    @HystrixCommand(fallbackMethod = "productFallBackMathod")
    public String sayHello() {
        return restTemplate.getForEntity("http://SERVICE-PRODUCT/sayHello", String.class).getBody();
    }

    /**
     * 熔断机制失败调用的方法，方法名 与  fallbackMethod的值保持一致即可
     * @return
     */
    public String productFallBackMathod(){
        return "product 已经失效！";
    }
}
