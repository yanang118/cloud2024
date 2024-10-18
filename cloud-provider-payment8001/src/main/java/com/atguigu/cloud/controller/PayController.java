package com.atguigu.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ReturnData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yanghe
 * @create 2024-09-28-15:55
 * @description: TODO
 */
@RestController
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping(value="/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ReturnData<String> addPay(@RequestBody Pay pay ){
        int i = payService.add(pay);
        return ReturnData.success("成功插入数据，返回值："+i);
    }

    @DeleteMapping(value="/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ReturnData<Integer> deletePay(@PathVariable("id") Integer id){
        int i = payService.delete(id);
        return ReturnData.success(i);
    }

    @PutMapping("/pay/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ReturnData<String> updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO,pay);
        int i = payService.update(pay);
        return ReturnData.success("updatePay:"+i);
    }

    @GetMapping("/pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询单条支付流水方法")
    public ReturnData<Pay> getById(@PathVariable("id") Integer id){

        if (id<0){throw new RuntimeException("id为负");}

        try {
            TimeUnit.SECONDS.sleep(62);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Pay pay = payService.getById(id);
        return ReturnData.success(pay);
    }

    @GetMapping("/pay/getAll")
    @Operation(summary = "查所有流水",description = "查询所有支付流水方法")
    public ReturnData<List<Pay>> getAll(){
        List<Pay> payList = payService.getAll();
        return ReturnData.success(payList);
    }
    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    private String getInfoByConsul(@Value("${atguigu.info}") String atguiguInfo)
    {
        return "atguiguInfo: "+atguiguInfo+"\t"+"port: "+port;
    }
}
