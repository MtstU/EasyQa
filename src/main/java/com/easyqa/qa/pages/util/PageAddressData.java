package com.easyqa.qa.pages.util;

import io.qameta.allure.Step;

public class PageAddressData {

    private String pageAddress;

    public PageAddressData (String pageAddress) {
        this.pageAddress = pageAddress;
    }

    @Step
    public String getPageAddress() {
        return this.pageAddress;
    }


}
