package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ReturnData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yanghe
 * @create 2024-10-17-16:27
 * @description: TODO
 */
@FeignClient(value = "seata-storage-service")
public interface StorageFeignApi
{
    /**
     * 扣减库存
     */
    @PostMapping(value = "/storage/decrease")
    ReturnData decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
