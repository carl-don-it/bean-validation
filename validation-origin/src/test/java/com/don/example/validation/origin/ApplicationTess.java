package com.don.example.validation.origin;

import com.don.example.validation.origin.Person;
import com.don.example.validation.origin.ValidationResult;
import com.don.example.validation.origin.ValidationUtils;
import org.hibernate.validator.constraints.Range;
import org.junit.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ExecutableValidator;
import java.util.Map;

/**
 *
 * @author Walker_Don
 * @version V1.0
 * @ClassName ApplicationTess
 * @date 2019年08月06日 下午 12:22
 */
public class ApplicationTess {


    @Test
    public void beanValidation() {
        Person person = new Person();
        person.setAge(12);
        person.setGender(2);
        @Range(min = 0, max = 1, message = "性别只能输入只能输入0或1") Integer gender = person.getGender();
        @NotNull Integer age = person.getAge();
        //    person.setName("李智龙");
        ValidationResult result = ValidationUtils.validateEntity(person);
        Map<String, String> map = result.getErrorMsg();
        boolean isError = result.isHasErrors();
        System.out.println("isError: " + isError);
        System.out.println(map);
    }

    @Test
    public void methodParam() throws NoSuchMethodException {
        new PersonService().getOne(0, "A哥");
    }
    @Test
    public void returnvalue() throws NoSuchMethodException {
        // 看到没 IDEA自动帮你前面加了个notNull
        @NotNull Person result = new PersonService().getOne(1, "A哥");
    }

    //@Valid注解用于验证级联的属
    @Test
    public void test3() throws NoSuchMethodException {
        // save.arg0 不能为null: null
        // new PersonService().save(null);
        new PersonService().save(new Person());
    }

}
 

