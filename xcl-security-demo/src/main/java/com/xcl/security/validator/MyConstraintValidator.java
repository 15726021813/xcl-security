package com.xcl.security.validator;

import com.xcl.security.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * MyConstraintValidator
 *
 * @author 徐长乐
 * @date 2020/4/21
 */
public class MyConstraintValidator implements ConstraintValidator<MyContraint,Object> {

    @Autowired
    HelloService helloService;

    @Override
    public void initialize(MyContraint constraintAnnotation) {
        System.out.println("my constraintcalidator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println(value);
        helloService.greeting((String) value);
        return false;
    }
}
