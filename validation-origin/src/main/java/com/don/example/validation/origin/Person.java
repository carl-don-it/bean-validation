package com.don.example.validation.origin;

//package com.aliyun.prophet.facade.partner.flaw;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.junit.Test;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class Person {
    @Length(max = 20, message = "姓名长度不能大于20")
    @NotEmpty(message = "姓名不能为空",groups = javax.xml.crypto.Data.class)
    private String name;
    @Range(min = 0, max = 1, message = "性别只能输入只能输入0或1")
    private Integer gender;
    @NotNull
    private Integer age;

    @Test
    public void fun1() {
        List<Integer> intList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        System.out.println(intList.getClass() == stringList.getClass());
    }

}
