package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;

/**
 * @author yanghe
 * @create 2024-10-17-16:25
 * @description: TODO
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);

}
