package com.chen.girl.exception;

import com.chen.girl.enums.ResultEnum;

//spring 对RuntimeException 才会进行事务回滚
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
