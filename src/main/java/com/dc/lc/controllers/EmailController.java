package com.dc.lc.controllers;

import com.dc.lc.api.EmailDTO;
import com.dc.lc.api.UserInfoDTO;
import com.dc.lc.service.LCAppEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailController {

    @Autowired
    private LCAppEmailService lcAppEmailService;

    @RequestMapping("/loadEmail")
    public String loadEmailForm(Model model){
        model.addAttribute("emailInfo",new EmailDTO());
        return "email-form";
    }

    @RequestMapping("/processEmail")
    public String processEmail(@SessionAttribute("userInfo") UserInfoDTO userInfoDTO,
                               @ModelAttribute("emailInfo") EmailDTO emailDTO){
        lcAppEmailService.sendEmail(userInfoDTO.getUserName(),emailDTO.getEmail(),"Friend");
        return "process-email";
    }
}
