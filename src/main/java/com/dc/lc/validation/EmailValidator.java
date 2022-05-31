package com.dc.lc.validation;

import com.dc.lc.api.UserRegistrationDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class EmailValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserRegistrationDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"communicationDTO.email","email.empty");

        String email = ((UserRegistrationDTO) target).getCommunicationDTO().getEmail();

        if(!email.endsWith("@dc.com")){
            errors.rejectValue("communicationDTO.email","email.invalid");
        }
    }
}
