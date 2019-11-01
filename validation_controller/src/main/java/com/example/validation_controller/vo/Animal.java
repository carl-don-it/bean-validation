package com.example.validation_controller.vo;

import com.example.validation_controller.myValidation.anno.CannotHaveBlank;
import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Walker_Don
 * @version V1.0
 * @ClassName Animal
 * @date 2019年08月05日 下午 12:15
 */
@Data
@ToString
public class Animal {
    private String name;



    private Integer age;

    //@NotBlank//只能作用在String上，不能为null，而且调用trim()后，长度必须大于0, ("test") 即：必须有实际字符
    @NotEmpty(message = "age不能为null，而且长度必须大于0(\" \",\"  \")")
    @CannotHaveBlank
    private String password;

    @NotNull//不能为null，但可以为empty(""," ","   ")
    private Date birthDay;

    //先@NotNull判定是否为空，然后@Valid进行级联校验
    //前者为null则后者不再执行
    //@Valid为一级级联
    @NotNull
    @Valid
    private Dog dog = new Dog();

    @Data
    @ToString
    class Dog {
        @NotNull(message = "name2不能为null")
        private String name2;
        private Integer age;
    }

}
