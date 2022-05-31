package com.dc.lc.formatter;

import com.dc.lc.api.AmountInfo;
import org.springframework.format.Formatter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class AmountFormatter implements Formatter<AmountInfo> {
    @Override
    public AmountInfo parse(String textAmount, Locale locale) throws ParseException {
        String[] textAmountArr = textAmount.split(" ");
        AmountInfo amountInfo = new AmountInfo();
        amountInfo.setBillAmount(new BigDecimal(textAmountArr[0]));
        amountInfo.setLocaleDefinition(textAmountArr[1]);
        String localeDefinition = textAmountArr[1];
        Locale localeRes = null;
        for (Locale l : NumberFormat.getAvailableLocales()) {
            String code = NumberFormat.getCurrencyInstance(l).getCurrency().getCurrencyCode();
            if (localeDefinition.equals(code)) {
                localeRes = l;
            }
        }
        Currency currency = Currency.getInstance(localeRes);
        amountInfo.setLocaleDefinition(currency.getSymbol(localeRes));
        return amountInfo;
    }

    @Override
    public String print(AmountInfo amountInfo, Locale locale) {
        return null;
    }
}
