package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yanghe
 * @create 2024-09-28-22:05
 * @description: TODO
 */
@RestController
public class OrderController {

    public static final String PaymentSrv_URL = "http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;


    // 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求

    // 增
    @GetMapping("/consumer/pay/add")
    public ReturnData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/add",payDTO,ReturnData.class);
    }
    // 删
    @GetMapping("/consumer/pay/del/{id}")
    public ReturnData deletePay(@PathVariable("id") Integer id){
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/del/"+id,id,ReturnData.class);
    }
    // 改
    @GetMapping("/consumer/pay/update")
    public ReturnData updatePay(@RequestBody PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/update",payDTO,ReturnData.class);
    }
    // 查single
    @GetMapping("/consumer/pay/get/{id}")
    public ReturnData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/"+id, ReturnData.class, id);
    }
    // 查
    @GetMapping("/consumer/pay/getAll")
    public ReturnData getPayInfo(){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/getAll/", ReturnData.class);
    }

    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }
}
