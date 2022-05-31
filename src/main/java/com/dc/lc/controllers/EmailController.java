package com.dc.lc.controllers;

import com.dc.lc.api.EmailDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {

    @RequestMapping("/loadEmail")
    public String loadEmailForm(@CookieValue("lcApp.username") String username,
                                Model model){
        model.addAttribute("username",username);
        model.addAttribute("emailInfo",new EmailDTO());
        return "email-form";
    }

    @RequestMapping("/processEmail")
    public String processEmail(@ModelAttribute("emailInfo") EmailDTO emailDTO){
        return "process-email";
    }
}
