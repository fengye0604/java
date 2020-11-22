package cn.sh.ideal.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidatorOfCannotHaveBlankValidator implements ConstraintValidator<MyValidatorOfCannotHaveBlank, String>{
	@Override
	public void initialize(MyValidatorOfCannotHaveBlank constraintAnnotation) {
	
	}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		//null时不进行校验
        if (value != null && value.contains(" ")) {
            //获取默认提示信息
            String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
            //defaultConstraintMessageTemplate 为MyValidatorOfCannotHaveBlankValidator的message设置的提示信息
            //禁用默认提示信息
            context.disableDefaultConstraintViolation();
            //设置提示语
            context.buildConstraintViolationWithTemplate("can not contains blank").addConstraintViolation();
            return false;
        }
        return true;
	}

}
