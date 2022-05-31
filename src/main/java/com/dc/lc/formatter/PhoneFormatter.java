package com.dc.lc.formatter;

import com.dc.lc.api.Phone;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PhoneFormatter implements Formatter<Phone> {
    @Override
    public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
        int index = completePhoneNumber.indexOf("-");
        String[] phoneArr = completePhoneNumber.split("-");
        Phone phone = new Phone();
        if (index == -1 || index == 0) {
            phone.setCountryCode("91");
            if(index ==-1 ){
                phone.setPhoneNo(phoneArr[0]);
            }else{
                phone.setPhoneNo(phoneArr[2]);
            }
        } else {
            phone.setCountryCode(phoneArr[0]);
            phone.setPhoneNo(phoneArr[1]);
        }
        return phone;
    }

    @Override
    public String print(Phone phone, Locale locale) {
        return phone.getCountryCode() + "-" + phone.getPhoneNo();
    }
}
