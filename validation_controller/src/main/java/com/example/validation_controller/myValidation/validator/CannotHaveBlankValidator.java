package com.example.validation_controller.myValidation.validator;

import com.example.validation_controller.myValidation.anno.CannotHaveBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义注解的处理类，需要实现ConstraintValidator
 */
public class CannotHaveBlankValidator implements ConstraintValidator<CannotHaveBlank, String> {

    private static final Logger logger = LoggerFactory.getLogger(CannotHaveBlankValidator.class);

    @Override
    public void initialize(CannotHaveBlank constraintAnnotation) {
    }

    //重写该方法进行处理
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //null时不进行校验
        if (value != null && value.contains(" ")) {

            //获取默认提示信息
            String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
            System.out.println("default message :" + defaultConstraintMessageTemplate);
            //禁用默认提示信息
            context.disableDefaultConstraintViolation();
            //设置提示语
            context.buildConstraintViolationWithTemplate("can not contains blank").addConstraintViolation();
            return false;
        }
        return true;
    }
}

