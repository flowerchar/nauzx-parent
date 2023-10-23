package com.flowerchar.nauzx.exception;

import com.flowerchar.nauzx.model.vo.common.Result;
import com.flowerchar.nauzx.model.vo.common.ResultCodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result error(){
        return Result.build(null, ResultCodeEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler(NauException.class)
    public Result error(NauException e){
        return Result.build(null, e.getResultCodeEnum());
    }
}
