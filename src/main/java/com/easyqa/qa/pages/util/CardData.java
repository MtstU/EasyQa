package com.easyqa.qa.pages.util;

public class CardData {
    private String cardName;
    private String cardDescription;
    private int issuePriority;

    public CardData (String cardName, String cardDescription, int issuePriority) {
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.issuePriority = issuePriority;
    }

    public String getCardName() {
        return this.cardName;
    }

    public String getCardDescription() {
        return this.cardDescription;
    }

    public int getIssuePriority() { return this.issuePriority; }
}
