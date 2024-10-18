package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ReturnData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yanghe
 * @create 2024-10-17-16:28
 * @description: TODO
 */
@FeignClient(value = "seata-account-service")
public interface AccountFeignApi
{
    //扣减账户余额
    @PostMapping("/account/decrease")
    ReturnData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}