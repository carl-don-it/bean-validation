package com.example.validation_controller;

import com.example.validation_controller.vo.Animal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author Walker_Don
 * @version V1.0
 * @Description TODO
 * @ClassName ValidationControllerApplicationTest
 * @date 2019年08月05日 下午 12:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationControllerApplicationTest {

    private final static Logger logger = LoggerFactory.getLogger(ValidationControllerApplicationTest.class);
    //自动注入spring框架的validator
    @Autowired
    private Validator validator;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void initMock() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * spring单元检验，不需要启动服务器
     *
     * @throws Exception
     */
    @Test
    public void testAnimal() throws Exception {
        String content = "{\"name\":\"elephant\",\"password\":\" \",\"birthDay\":" + System.currentTimeMillis() + "}";
        //        String content = "{\"name\":\"elephant\",\"password\":null}";
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/animal/test2")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        logger.info(result);
        System.out.println(result);
    }


    //spring的validator，自动注入
    @Test
    public void testJSR303_hibernateValidator() {
        //调用JSR303验证工具，校验参数
        //不支持notEmpty,hibernate支持的
        //工厂
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        //获取检验器
        Validator validator = validatorFactory.getValidator();
        //验证
        validate(validator);
    }

    //hibernate的validator
    @Test
    public void testJSR303_springValidator() {
        validate(validator);
    }

    //验证
    private void validate(Validator validator) {
        Set<ConstraintViolation<Animal>> violations = validator.validate(new Animal());

        for (ConstraintViolation<Animal> violation : violations) {
            String errMessage = violation.getMessage();
            System.out.println(errMessage);
        }
    }

}
