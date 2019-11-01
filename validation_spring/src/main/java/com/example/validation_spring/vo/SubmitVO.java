package com.example.validation_spring.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author Walker_Don
 * @version V1.0
 * @Description TODO
 * @ClassName SubmitVO
 * @date 2019年08月05日 下午 5:29
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubmitVO {//extends BaseVO

    @NotNull(message="厂商不能为空")
    private Long companyId;

    //@Length(min=0, max=100, message="标题请控制在" + Constants.MAX_TITLE + "个字符以内")
    @Length(min=0, max=100, message="标题请控制在100个字符以内")
    @NotNull(message="标题不能为空")
    private String title;

    //@Length(min=0, max=65535, message="修复方案长度不能超过" + Constants.MAX_FIX_ADVICE)
    @Length(min=0, max=65535, message="修复方案长度不能超过100" )
    @NotNull(message="修复方案不能为空")
    private String fixAdvice;
}

