package com.dc.lc.formatter;

import com.dc.lc.api.CardInfo;
import org.springframework.format.Formatter;

import javax.smartcardio.Card;
import java.text.ParseException;
import java.util.Locale;

public class CardFormatter implements Formatter<CardInfo> {
    @Override
    public CardInfo parse(String textCardInfo, Locale locale) throws ParseException {
        CardInfo cardInfo = new CardInfo();
        String [] cardInfoArr = textCardInfo.split("-");
        cardInfo.setFirstFourDigit(cardInfoArr[0]);
        cardInfo.setSecondFourDigit(cardInfoArr[1]);
        cardInfo.setThirdFourDigit(cardInfoArr[2]);
        cardInfo.setLastFourDigit(cardInfoArr[3]);
        return cardInfo;
    }

    @Override
    public String print(CardInfo cardInfo, Locale locale) {
        return null;
    }
}
