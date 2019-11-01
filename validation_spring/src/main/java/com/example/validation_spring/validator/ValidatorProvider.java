package com.example.validation_spring.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 用来校验实体，构建并存储校验后的信息ValidatorProvider
 * <p>
 * 就是用来包装javax.validation.Validator
 *
 * @author: lizhilong
 * @date: 2017-11-15 11:40:59
 */
@AllArgsConstructor
@Getter
public class ValidatorProvider {
    private final Validator validator;

    public <T> ViolationBuild validate(T object) {
        Set<ConstraintViolation<T>> violations;
        violations = validator.validate(object);
        return ViolationBuild.build(violations);
    }

    public <T> ViolationBuild validate(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> violations;
        violations = validator.validate(object, groups);
        return ViolationBuild.build(violations);
    }

    public <T> ViolationBuild validateProperty(T object, String propertyName, Class<?>... groups) {
        Set<ConstraintViolation<T>> violations;
        violations = validator.validateProperty(object, propertyName, groups);
        return ViolationBuild.build(violations);
    }

    public <T> ViolationBuild validateValue(Class<T> beanType, String propertyName, Object value, Class<?>... groups) {
        Set<ConstraintViolation<T>> violations;
        violations = validator.validateValue(beanType, propertyName, value, groups);
        return ViolationBuild.build(violations);
    }
}
