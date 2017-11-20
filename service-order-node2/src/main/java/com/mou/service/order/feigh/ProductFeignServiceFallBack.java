package com.mou.service.order.feigh;

import org.springframework.stereotype.Component;

/**
 * Created by mou on 2017/11/14.
 *
 * @author Mou
 * @date 2017/11/14
 * @since 1.0
 */
@Component
public class ProductFeignServiceFallBack implements ProductFeignService {

    @Override
    public String sayHello() {
        return "product 服务失效了！！！";
    }
}
