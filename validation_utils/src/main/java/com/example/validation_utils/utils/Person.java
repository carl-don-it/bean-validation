package com.example.validation_utils.utils;

//package com.aliyun.prophet.facade.partner.flaw;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Data
@ToString
public class Person {
    @Length(max = 20, message = "姓名长度不能大于20")
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @Range(min = 0, max = 1, message = "性别只能输入只能输入0或1")
    private Integer gender;
    private Integer age;
}
