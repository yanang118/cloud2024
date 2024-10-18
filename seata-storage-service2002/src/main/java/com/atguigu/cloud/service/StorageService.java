package com.atguigu.cloud.service;

/**
 * @author yanghe
 * @create 2024-10-17-16:41
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}