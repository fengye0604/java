package cn.sh.ideal.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import cn.sh.ideal.annotation.MyAnnotation;
import cn.sh.ideal.bean.ResultBean;

/**
 * 
 * @Description	日志记录方法的执行时长
 * @author yanggaoli
 * @date 2020年3月12日下午2:15:00
 */
@Component
@Aspect
public class LogRecord {
	public static Logger logger = LoggerFactory.getLogger(LogRecord.class);
	@Pointcut("execution(* cn.sh.ideal.service..*.*(..))")
    public void pointCut(){}
//	
//    @Before("pointCut()")
	/*
    @Before(value = "@annotation(myAnnotation)")
    public void doBefore(JoinPoint joinPoint,MyAnnotation myAnnotation){
    	logger.info("前置通知");
    }
     */
//    @After("pointCut()")
	/*
    @After(value = "@annotation(myAnnotation)")
    public void doAfter(JoinPoint joinPoint,MyAnnotation myAnnotation){
    	logger.info("@After后置通知");
    }
    */
    /**
     * 
     * @Description	返回通知，可以通过返回通知修改返回数据。
     * @author yanggaoli
     * @date 2020年3月20日下午12:22:16
     * @param joinPoint
     * @param returnVal
     * @param myAnnotation
     * @returnResultBean
     * @version
     */
//    @AfterReturning(pointcut="pointCut()",returning="returnVal")
	/*
    @AfterReturning(value = "@annotation(myAnnotation)",returning="returnVal")
    public ResultBean afterReturn(JoinPoint joinPoint,Object returnVal,MyAnnotation myAnnotation){
    	logger.info("@AfterReturning返回通知");
    	ResultBean resultBean = (ResultBean) returnVal;
    	resultBean.setData("@After最终通知");
    	return  resultBean;
    }
    */
//    @AfterThrowing(pointcut="pointCut()",throwing="error")
	@AfterThrowing(value = "@annotation(myAnnotation)",throwing="error")
    public void afterThrowing(JoinPoint joinPoint,Exception error,MyAnnotation myAnnotation){
		error.printStackTrace();
		logger.info(error.getMessage());
    }
   
    
//    @Around("pointCut()")
//    public <T> T around(ProceedingJoinPoint pjp){
	/**
	 * @version 1.0
	 * @author yanggaoli 
	 * @date 2020-3-19 上午10:40:55
	 * @Title: around 
	 * @Description 环绕通知，计算service的执行时长
	 * @param pjp
	 * @param myAnnotation
	 * @return
	 * @throws Throwable 
	 */
    @Around(value = "@annotation(myAnnotation)")
    public <T> T around(ProceedingJoinPoint pjp,MyAnnotation myAnnotation) throws Throwable{
    	Object obj = null;
    	long methodStartTime = System.currentTimeMillis();
    	obj = pjp.proceed();
        long methodEndTime = System.currentTimeMillis();
        if(myAnnotation.flag()){
        	logger.info("{}方法的执行时长是{}毫秒!\r\n",myAnnotation.value(),(methodEndTime-methodStartTime));
        }else{
        	logger.info("{}方法的执行时长是{}毫秒!\r\n",myAnnotation.value(),(methodEndTime-methodStartTime));
        }
        return (T) obj;
    }
}
