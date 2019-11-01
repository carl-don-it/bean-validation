package com.example.validation_controller.controller;

import com.example.validation_controller.vo.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Walker_Don
 * @version V1.0
 * @ClassName AnimalController
 * @date 2019年08月05日 下午 12:15
 */

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private final static Logger logger = LoggerFactory.getLogger(AnimalController.class);

    @PostMapping
    public Animal createAnimal(@Valid @RequestBody Animal animal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(o -> {
                FieldError error = (FieldError) o;
                logger.error(error.getField() + ":" + error.getDefaultMessage());
            });
        }
        logger.info(animal.toString());
        return animal;
    }

    @PostMapping("/test2")
    public Map<String, Object> createAnimal2(@Valid @RequestBody Animal animal, BindingResult bindingResult) {//先构造再传参，绝对非空
        //返回信息
        HashMap<String, Object> result = new HashMap<>();
        //有错误返回错误信息
        if (bindingResult.hasErrors()) {
            //解析错误
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            StringBuilder stringBuilder = new StringBuilder();
            for (FieldError fieldError : fieldErrors) {

                String field = fieldError.getField();

                String defaultMessage = fieldError.getDefaultMessage();

                stringBuilder.append(field).append(" : ").append(defaultMessage).append(",");
            }
            result.put("code", "400");//错误编码
            result.put("message", stringBuilder.toString());//错误信息
            return result;
        }
        //成功返回信息
        result.put("code", "200");//成功编码200
        result.put("data", animal);//成功返回数据
        return result;
    }
}