package com.atguigu.cloud.resp;

import lombok.Data;

/**
 * @author yanghe
 * @create 2024-09-28-20:20
 * @description: TODO
 */
@Data
public class ReturnData<T> {

    private String code;
    private String message;
    private T data;
    private long timestamp; //接口调用时间

    public ReturnData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ReturnData<T> success(T data){
        ReturnData<T> returnData = new ReturnData<T>();
        returnData.setCode(ReturnCodeEnum.RC200.getCode());
        returnData.setMessage(ReturnCodeEnum.RC200.getMessage());
        returnData.setData(data);
        return returnData;
    }

    public static <T> ReturnData<T> fail(String code, String message){
        ReturnData<T> returnData = new ReturnData<T>();
        returnData.setCode(code);
        returnData.setMessage(message);
        return returnData;
    }
}
