package com.mou.service.order.feigh;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by mou on 2017/11/14.
 *
 * @author Mou
 * @date 2017/11/14
 * @since 1.0
 */
@FeignClient(name = "service-product", fallback = ProductFeignServiceFallBack.class)
public interface ProductFeignService {

    @GetMapping("/sayHello")
    String sayHello();
}
