package com.flowerchar.nauzx.exception;


import com.flowerchar.nauzx.model.vo.common.ResultCodeEnum;
import lombok.Data;

@Data
public class NauException extends RuntimeException{

    private Integer code;

    private String message;

    private ResultCodeEnum resultCodeEnum;

    public NauException(ResultCodeEnum resultCodeEnum){
        this.resultCodeEnum = resultCodeEnum;
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }
}
