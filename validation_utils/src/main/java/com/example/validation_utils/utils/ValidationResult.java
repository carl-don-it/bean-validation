package com.example.validation_utils.utils;

//package com.aliyun.prophet.facade.partner.flaw;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

/**
 * 校验工具类返回的数据ValidationResult
 *
 * @author lizhilong
 */
@Data
@ToString
public class ValidationResult {

    // 校验结果是否有错
    private boolean hasErrors;

    // 校验错误信息
    private Map<String, String> errorMsg;
}