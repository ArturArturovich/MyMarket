package com.geekbrains.artur.springMarket.controller.validation;

import com.geekbrains.artur.springMarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailNotRegisteredValidator implements ConstraintValidator<EmailNotRegistered, String> {

    private final UserService userService;

    @Autowired
    public EmailNotRegisteredValidator(UserService userService){this.userService = userService;}


    @Override
    public void initialize(EmailNotRegistered constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !userService.existsUserByEmail(value);
    }
}
