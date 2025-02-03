package com.facomp.pethub.configuration.annotation.validator;

import com.facomp.pethub.configuration.annotation.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Value("${user.password.regex}")
    private String passwordRegex;

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return password != null && password.matches(passwordRegex);
    }
}