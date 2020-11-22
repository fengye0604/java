package cn.sh.ideal.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sh.ideal.bean.ResultBean;
import cn.sh.ideal.enums.ErrorInfo;
import cn.sh.ideal.exception.MyException;
/**
 * 
 * @Description	设置全局异常
 * @author yanggaoli
 * @date 2020年3月19日下午4:53:46
 */
@ControllerAdvice
public class ExceptionConfigController {
	
	public static Logger logger = Logger.getLogger(ExceptionConfigController.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean exceptionHandler(Exception e){
    	e.printStackTrace();
    	logger.info(e.getMessage());
        return new ResultBean(ErrorInfo.Error001.getCode(),ErrorInfo.Error001.getMessage());
//    	return new ResultBean("1",e.getMessage());
    }
    
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean handleBindException(Exception e) {
    	e.printStackTrace();
        //打印校验住的所有的错误信息
        StringBuilder sb = new StringBuilder("参数错误：[");
        List<ObjectError> list = ((BindException) e).getAllErrors();
        for (ObjectError item : list) {
            sb.append(item.getDefaultMessage());
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        String msg = sb.toString();
        return new ResultBean(ErrorInfo.Error003.getCode(),msg);
    }
    
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ResultBean handleMyException(MyException e) {
    	e.printStackTrace();
        //打印校验住的所有的错误信息
        return new ResultBean(ErrorInfo.Error003.getCode(),e.getMessage());
    }
}