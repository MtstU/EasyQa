package com.easyqa.qa.pages.util;

import io.qameta.allure.Step;

public class CardData {
    private String cardName;
    private String cardDescription;
    private int issuePriority;

    public CardData (String cardName, String cardDescription, int issuePriority) {
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.issuePriority = issuePriority;
    }
    @Step
    public String getCardName() {
        return this.cardName;
    }
    @Step
    public String getCardDescription() {
        return this.cardDescription;
    }
    @Step
    public int getIssuePriority() { return this.issuePriority; }
}
