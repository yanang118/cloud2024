package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ReturnData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yanghe
 * @create 2024-10-14-22:51
 * @description: TODO
 */
@FeignClient(value = "nacos-payment-provider",fallback = PayFeignSentinelApiFallBack.class)
public interface PayFeignSentinelApi
{
    @GetMapping("/pay/nacos/get/{orderNo}")
    public ReturnData getPayByOrderNo(@PathVariable("orderNo") String orderNo);
}
