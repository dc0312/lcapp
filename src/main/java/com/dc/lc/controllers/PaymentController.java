package com.dc.lc.controllers;

import com.dc.lc.api.AmountInfo;
import com.dc.lc.api.PaymentInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
public class PaymentController {

    @RequestMapping("/payment")
    public String paymentPage(@ModelAttribute("paymentInfo")PaymentInfoDTO paymentInfoDTO){
        return "payment-page";
    }

    @RequestMapping("/paymentDetails")
    public String showPaymentDetails(@ModelAttribute("paymentInfo") PaymentInfoDTO paymentInfoDTO){
        return "payment-details";
    }
}
