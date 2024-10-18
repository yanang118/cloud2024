package com.atguigu.cloud.controller;

import com.atguigu.cloud.resp.ReturnData;
import com.atguigu.cloud.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanghe
 * @create 2024-10-17-16:48
 * @description: TODO
 */
@RestController
public class StorageController
{
    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public ReturnData decrease(Long productId, Integer count) {

        storageService.decrease(productId, count);
        return ReturnData.success("扣减库存成功!");
    }
}