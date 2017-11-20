package com.mou.service.loadbalance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mou on 2017/11/10.
 *
 * @author Mou
 * @date 2017/11/10
 * @since 1.0
 */
@RestController
public class ServiceLoadbalanceController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/product/sayHello")
    public String productSayHello() {
        return restTemplate.getForEntity("http://SERVICE-PRODUCT/sayHello", String.class).getBody();
    }

    @GetMapping("/order/sayHello")
    public String orderSayHello() {
        return restTemplate.getForEntity("http://SERVICE-ORDER/sayHello", String.class).getBody();
    }
}
