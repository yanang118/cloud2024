package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ReturnCodeEnum;
import com.atguigu.cloud.resp.ReturnData;
import org.springframework.stereotype.Component;

/**
 * @author yanghe
 * @create 2024-10-14-22:53
 * @description: TODO
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi {
    @Override
    public ReturnData getPayByOrderNo(String orderNo) {
        return ReturnData.fail(ReturnCodeEnum.RC500.getCode(), "对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}

