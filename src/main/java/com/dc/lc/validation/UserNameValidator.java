package com.dc.lc.validation;

import com.dc.lc.api.UserRegistrationDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserNameValidator implements Validator {

    //This method tells for which DTO this validator stands for.
    @Override
    public boolean supports(Class<?> clazz) {
        return UserRegistrationDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"userName","username.empty","Username cannot be empty.");

        String userName = ((UserRegistrationDTO) target).getUserName();

        if(!userName.contains("_")){
            errors.rejectValue("userName","userName.invalid","UserName should contain \"-\"");
        }
    }
}
