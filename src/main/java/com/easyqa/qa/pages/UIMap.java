package com.easyqa.qa.pages;

import org.openqa.selenium.By;

public class UIMap {

    public static By login = By.id("user_email");
    public static By password = By.id("user_password");
    public static By loginBtn = By.name("commit");

    public static By profileLink = By.xpath("//a[@href='/user/edit']");
}
