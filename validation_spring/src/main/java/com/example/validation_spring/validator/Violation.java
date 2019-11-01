package com.example.validation_spring.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * 自己的Violation实体
 *
 *  就是用来包装javax.validation.ConstraintViolation
 *
 * Created by Jackielee on 2017
 * @author: lizhilong
 * @date:   2017-11-14 18:01:34
 */
@Getter
@AllArgsConstructor
public class Violation implements Serializable {

    private static final long serialVersionUID = -1731546219600067986L;

    private final String message;

    private final Object bean;

    private final String property;

    private final Object value;
}
