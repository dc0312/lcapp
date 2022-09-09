package com.dc.lc.service.impl;

import com.dc.lc.service.LCAppEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class LCAppEmailServiceImpl implements LCAppEmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String userName, String userEmail, String result) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(userEmail);
        simpleMailMessage.setSubject("Love Calculator Application Result");
        simpleMailMessage.setText("Hi "+userName +"\n" +"The result predicted by the LCApp is "+result);

        javaMailSender.send(simpleMailMessage);
    }
}
