package com.don.example.validation.origin;

import com.sun.xml.internal.ws.api.server.SDDocumentFilter;
import jdk.nashorn.internal.runtime.ScriptFunctionData;

import javax.validation.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * todo
 *
 * @author Carl Don
 * @Date 2023/5/24  20:28
 * @Version 1.0
 */
public class PersonService {
    public Person getOne1(Integer id, String name) {
        return null;
    }

    public Person getOne2(Integer id, String name) {
        if (id == null) {
            throw new IllegalArgumentException("id不能为null");
        }
        if (id < 1) {
            throw new IllegalArgumentException("id必须大于等于1");
        }

        return null;
    }

    public Person getOne3(Integer id, String name) throws NoSuchMethodException {


        // ... 模拟逻辑执行，得到一个result结果，准备返回
        Person result = null;

        // 在结果返回之前校验
        if (result == null) {
            throw new IllegalArgumentException("返回结果不能为null");
        }
        return result;
    }

    public Person getOne4(@NotNull @Min(1) Integer id, String name) throws NoSuchMethodException {
        // 校验逻辑
        Method currMethod = this.getClass().getMethod("getOne", Integer.class, String.class);
        Set<ConstraintViolation<PersonService>> validResult = obtainExecutableValidator().validateParameters(this, currMethod, new Object[]{id, name});
        if (!validResult.isEmpty()) {
            // ... 输出错误详情validResult
            validResult.stream().map(v -> v.getPropertyPath() + " " + v.getMessage() + ": " + v.getInvalidValue()).forEach(System.out::println);
            throw new IllegalArgumentException("参数错误");
        }


        return null;
    }

    public @NotNull Person getOne(@NotNull @Min(1) Integer id, String name) throws NoSuchMethodException {

        // ... 模拟逻辑执行，得到一个result
        Person result = null;

        // 在结果返回之前校验
        Method currMethod = this.getClass().getMethod("getOne", Integer.class, String.class);
        Set<ConstraintViolation<PersonService>> validResult = obtainExecutableValidator().validateReturnValue(this, currMethod, result);
        if (!validResult.isEmpty()) {
            // ... 输出错误详情validResult
            validResult.stream().map(v -> v.getPropertyPath() + " " + v.getMessage() + ": " + v.getInvalidValue()).forEach(System.out::println);
            throw new IllegalArgumentException("参数错误");
        }
        return result;
    }

//@Valid注解用于验证级联的属
    public void save(@NotNull @Valid
                             Person person) throws NoSuchMethodException {
        Method currMethod = this.getClass().getMethod("save", Person.class);
        Set<ConstraintViolation<PersonService>> validResult = obtainExecutableValidator().validateParameters(this, currMethod, new Object[]{person});
        if (!validResult.isEmpty()) {
            // ... 输出错误详情validResult
            validResult.stream().map(v -> v.getPropertyPath() + " " + v.getMessage() + ": " + v.getInvalidValue()).forEach(System.out::println);
            throw new IllegalArgumentException("参数错误");
        }
    }


    // 用于Java Bean校验的校验器
    private Validator obtainValidator() {
        // 1、使用【默认配置】得到一个校验工厂  这个配置可以来自于provider、SPI提供
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        // 2、得到一个校验器
        return validatorFactory.getValidator();
    }

    // 用于方法校验的校验器
    private ExecutableValidator obtainExecutableValidator() {
        return obtainValidator().forExecutables();
    }
}

