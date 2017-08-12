package com.chen.girl.handle;

import com.chen.girl.domain.Result;
import com.chen.girl.exception.GirlException;
import com.chen.girl.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


//下面这个注解本身已经使用了@Compoent 会被组件扫描到
@ControllerAdvice
public class ExceptionHandle {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /*
    @ExceptionHandler 注解 能够处理同一个控制器类中所有的处理器方法的异常
    从sring3.2开始，只要将ExceptionHandler 定义在控制器通知类中就可以实现处理 所有控制器中处理器方法所抛出的异常
    即当结合使用 ControllerAdvice，ExceptionHandler时，就处理整个应用程序中所有控制器的异常
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException)e;
            return ResultUtil.Error(girlException.getCode(), girlException.getMessage());
        }else {
            logger.info("系统异常:" , e);
            //logger.info("系统异常" +e);
            return ResultUtil.Error(403, "Unknown error");
        }
    }
}
