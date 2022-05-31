package com.dc.lc.controllers;

import com.dc.lc.api.CommunicationDTO;
import com.dc.lc.api.Phone;
import com.dc.lc.api.UserRegistrationDTO;
import com.dc.lc.validation.EmailValidator;
import com.dc.lc.validation.UserNameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private EmailValidator emailValidator;

    @RequestMapping("/register")
    public String registerUser(@ModelAttribute("usrReg") UserRegistrationDTO userRegistrationDTO) {

        //Load Data in form when form is rendering
        Phone phone = new Phone();
        phone.setCountryCode("91");
        phone.setPhoneNo("1234567890");

        CommunicationDTO communicationDTO = new CommunicationDTO();
        communicationDTO.setPhone(phone);

        userRegistrationDTO.setCommunicationDTO(communicationDTO);
        return "registration-page";
    }

    @RequestMapping("/process-registration")
    public String processRegistration(@Valid @ModelAttribute("usrReg") UserRegistrationDTO userRegistrationDTO,
                                      BindingResult result) {
        emailValidator.validate(userRegistrationDTO,result);
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error.getDefaultMessage());
            }
            return "registration-page";
        }
        return "registration-details";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new UserNameValidator() );
    }
}
