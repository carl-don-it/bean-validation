package com.example.validation_utils;

import com.example.validation_utils.utils.Person;
import com.example.validation_utils.utils.ValidationResult;
import com.example.validation_utils.utils.ValidationUtils;
import org.junit.Test;

import java.util.Map;

/**
 * todo
 *
 * @author Walker_Don
 * @version V1.0
 * @ClassName ApplicationTess
 * @date 2019年08月06日 下午 12:22
 */
public class ApplicationTess {

    @Test
    public void testValidation() {
        Person person = new Person();
        person.setAge(12);
        person.setGender(2);
        //    person.setName("李智龙");
        ValidationResult result = ValidationUtils.validateEntity(person);
        Map<String, String> map = result.getErrorMsg();
        boolean isError = result.isHasErrors();
        System.out.println("isError: " + isError);
        System.out.println(map);
    }
}
 

