package com.dc.lc.api;

public class CardInfo {

    private String firstFourDigit;
    private String secondFourDigit;
    private String thirdFourDigit;
    private String lastFourDigit;

    public String getFirstFourDigit() {
        return firstFourDigit;
    }

    public void setFirstFourDigit(String firstFourDigit) {
        this.firstFourDigit = firstFourDigit;
    }

    public String getSecondFourDigit() {
        return secondFourDigit;
    }

    public void setSecondFourDigit(String secondFourDigit) {
        this.secondFourDigit = secondFourDigit;
    }

    public String getThirdFourDigit() {
        return thirdFourDigit;
    }

    public void setThirdFourDigit(String thirdFourDigit) {
        this.thirdFourDigit = thirdFourDigit;
    }

    public String getLastFourDigit() {
        return lastFourDigit;
    }

    public void setLastFourDigit(String lastFourDigit) {
        this.lastFourDigit = lastFourDigit;
    }

    @Override
    public String toString() {
        return firstFourDigit + "-" + secondFourDigit + "-" + thirdFourDigit + "-" + lastFourDigit;
    }
}
