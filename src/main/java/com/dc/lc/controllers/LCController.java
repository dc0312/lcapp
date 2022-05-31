package com.dc.lc.controllers;

import com.dc.lc.api.UserInfoDTO;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class LCController {

    @RequestMapping("/")
    public String getHomePage(@ModelAttribute("userInfo") UserInfoDTO userInfoDTO,
                              HttpServletRequest request){
        Cookie [] cookies = request.getCookies();
        for(Cookie cookie :  cookies){
            if("lcApp.username".equals(cookie.getName())){
                userInfoDTO.setUserName(cookie.getValue());
            }
        }
        return "home-page";
    }

    @RequestMapping("/process-homepage")
    public String processHomepage(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfoDTO,
                                  BindingResult result,HttpServletResponse response){
        Cookie cookie = new Cookie("lcApp.username",userInfoDTO.getUserName());
        cookie.setMaxAge(60*5);
        response.addCookie(cookie);
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
