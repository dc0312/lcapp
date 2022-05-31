package com.dc.lc.api;

public class PaymentInfoDTO {

    private CardInfo cardInfo;

    private AmountInfo amount;

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    public AmountInfo getAmount() {
        return amount;
    }

    public void setAmount(AmountInfo amount) {
        this.amount = amount;
    }
}
