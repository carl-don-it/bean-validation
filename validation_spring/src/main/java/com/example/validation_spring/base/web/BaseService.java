package com.example.validation_spring.base.web;

import com.example.validation_spring.validator.ValidatorProvider;
import com.example.validation_spring.validator.ViolationBuild;
import com.example.validation_spring.vo.SubmitVO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Validator;

/**
 * BaseService让自己的service继承此类
 * java不能多继承 所以如果已经继承了别的类，可以将此类注入出来
 * 此类是为了拿到一个单例的ValidatorProvider
 * BaseService
 *
 * @author: lizhilong
 * @date: 2017-11-15 11:41:24
 */

public abstract class BaseService {

    @Autowired
    protected Validator validator;

    private ValidatorProvider validatorProvider;

    protected ValidatorProvider getValidatorProvider() {
        if (validatorProvider == null) {
            validatorProvider = new ValidatorProvider(validator);
        }
        return validatorProvider;
    }

    public void save(SubmitVO submitVO) {
        /**
         * getValidatorProvider()此方法是BaserService中，
         * 上面说到本人的service是继承此
         * service的所以可以直接用
         **/
        ValidatorProvider validatorProvider = getValidatorProvider();
        /**
         * validatorProvider调用validate（Object obj）进行校验
         * 返回ViolationBuild
         **/
        ViolationBuild validateFlaw = validatorProvider.validate(submitVO);
        /**
         * 此时如果校验有失败的 容器中便会存储信息，ViolationBuild可以通过自己的
         * getMessage方法获取信息（此方法可以自己封装成自己想要的样子）
         **/
        System.out.println(validateFlaw.getMessage());
    }
}