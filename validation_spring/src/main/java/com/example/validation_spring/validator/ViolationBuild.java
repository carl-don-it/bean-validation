package com.example.validation_spring.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.collections.CollectionUtils;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 就是用来包装Set<ConstraintViolation<T>>
 *
 * @author: lizhilong
 * @date: 2017-11-15 11:41:12
 */
@AllArgsConstructor
public class ViolationBuild {

    @Getter
    private Set<Violation> violations;

    /**
     * 获取第一条violation信息
     *
     * @return
     */
    public String getMessage() {
        List<String> list = new ArrayList<String>();
        for (Violation violation : violations) {
            list.add(violation.getMessage());
        }
        return list.size() > 0 ? list.get(0) : "";
    }

    /**
     * 把Set<ConstraintViolation<T>>转换成自己的Set<Violation>，存储再violationBuild中
     *
     * @param cvs
     * @param <T>
     * @return
     */
    public static <T> ViolationBuild build(Set<ConstraintViolation<T>> cvs) {
        Set<Violation> result = new HashSet<Violation>();
        if (CollectionUtils.isNotEmpty(cvs)) {
            for (ConstraintViolation cv : cvs) {
                result.add(new Violation(cv.getMessage(), cv.getRootBean() == null ? null : cv.getRootBean().toString(),
                        cv.getPropertyPath() == null ? null : cv.getPropertyPath().toString(),
                        cv.getInvalidValue()));
            }
        }
        return new ViolationBuild(result);
    }
}
