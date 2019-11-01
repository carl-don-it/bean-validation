package com.example.validation_controller.myValidation.validator;

import com.example.validation_controller.myValidation.anno.CannotHaveBlank;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * todo
 *
 * @author Walker_Don
 * @version V1.0
 * @ClassName CannotHaveBlankValidator
 * @date 2019年08月06日 下午 2:18
 */
public class CannotHaveBlankValidator implements ConstraintValidator<CannotHaveBlank, String> {

    @Override
    public void initialize(CannotHaveBlank constraintAnnotation) {
    }

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

