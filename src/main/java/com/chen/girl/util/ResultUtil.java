package com.chen.girl.util;

import com.chen.girl.domain.Result;

public class ResultUtil {

    public static Result Success(Object object) {
        Result result = new Result();
        result.setMsg("success！");
        result.setCode(400);
        result.setData(object);

        return result;
    }

    public static Result Success() {
        return Success(null);
    }

    public static  Result Error(Integer code,String msg){

        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);

        return result;
    }


}
