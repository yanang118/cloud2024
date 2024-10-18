package com.atguigu.cloud.exp;

import com.atguigu.cloud.resp.ReturnCodeEnum;
import com.atguigu.cloud.resp.ReturnData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yanghe
 * @create 2024-09-28-21:09
 * @description: TODO
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ReturnData<String> exception(Exception e){
        log.error("exception{}",e.getMessage(),e);
        return ReturnData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}
