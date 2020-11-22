package cn.sh.ideal.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 字符串不能包含空格
 * @Description TODO
 * @author yanggaoli
 * @date 2020-6-17 上午12:43:25
 * @version v1.0
 */
@Target({ElementType.METHOD, 
		 ElementType.FIELD, 
		 ElementType.ANNOTATION_TYPE, 
		 ElementType.CONSTRUCTOR, 
		 ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {MyValidatorOfCannotHaveBlankValidator.class})
public @interface MyValidatorOfCannotHaveBlank {
	//默认错误消息
    String message() default "不能包含空格";
    //分组
    Class<?>[] groups() default {};
    //负载
    Class<? extends Payload>[] payload() default {};
    //指定多个时使用
    @Target({	ElementType.FIELD, 
    			ElementType.METHOD, 
    			ElementType.PARAMETER, 
    			ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
    	MyValidatorOfCannotHaveBlank[] value();
    }
}
