package com.easyqa.qa.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public void enterLogin(String userLogin) {

        $(UIMap.login).click();
        $(UIMap.login).clear();
        $(UIMap.login).sendKeys(userLogin);
    }

    public void enterPassword(String userPassword) {

        $(UIMap.password).click();
        $(UIMap.password).clear();
        $(UIMap.password).sendKeys(userPassword);
    }

    public DashboardPage clickLoginBtn() {
        $(UIMap.loginBtn).click();
        return page(DashboardPage.class);

    }
}
