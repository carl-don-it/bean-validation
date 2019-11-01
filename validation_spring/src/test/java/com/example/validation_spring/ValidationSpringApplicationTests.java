package com.example.validation_spring;

import com.example.validation_spring.service.BaseServiceTest;
import com.example.validation_spring.vo.SubmitVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.BaseStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidationSpringApplicationTests {

    @Autowired
    private BaseServiceTest baseServiceTest;
    /**
     * 测试封装后的validator
     */
    @Test
    public void contextLoads() {
        SubmitVO submitVO = new SubmitVO(2L, "标题很傻", "fixadvice");
        //new BaseServiceTest().save(new SubmitVO());
        baseServiceTest.save(new SubmitVO());
    }

}
