package com.dc.lc.api;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class AmountInfo {
    private BigDecimal billAmount;
    private String localeDefinition;

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public String getLocaleDefinition() {
        return localeDefinition;
    }

    public void setLocaleDefinition(String localeDefinition) {
        this.localeDefinition = localeDefinition;
    }

    @Override
    public String toString() {
        return localeDefinition + " " + billAmount;
    }
}
