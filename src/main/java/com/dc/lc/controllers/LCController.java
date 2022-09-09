package com.dc.lc.controllers;

import com.dc.lc.api.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"userInfo"})
public class LCController {

    @RequestMapping("/")
    public String getHomePage(Model model){

        model.addAttribute("userInfo", new UserInfoDTO());
        return "home-page";
    }

    @RequestMapping("/process-homepage")
    public String processHomepage(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfoDTO,
                                  BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            for(ObjectError error : errors){
                System.out.println(error.getDefaultMessage());
            }
            return "home-page";
        }
        return "result-page";
    }
}
