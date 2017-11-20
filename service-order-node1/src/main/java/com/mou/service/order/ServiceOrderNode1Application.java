package com.mou.service.order;

import com.mou.service.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// 开启注册中心服务端
@EnableEurekaClient
// 开启断路由功能呢
@EnableCircuitBreaker
@RestController
public class ServiceOrderNode1Application {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(ServiceOrderNode1Application.class, args);
	}

	@GetMapping("/sayHello")
	public String sayOrderHello() {
		return "order say hello noed1!!!";
	}

	@GetMapping("/product/sayHello")
	public String sayProductHello() {
		return productService.sayHello();
	}
}
