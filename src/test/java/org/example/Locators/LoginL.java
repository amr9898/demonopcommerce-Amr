package org.example.Locators;

import org.openqa.selenium.By;

public enum LoginL {
    MAIN_PAGE_LOGIN_BUTTON(By.xpath("//*[@class='ico-login']")),
    LOGIN_EMAIL_FIELD(By.xpath("//*[@id='Email']")),
    LOGIN_PASSWORD_FIELD(By.xpath("//*[@id='Password']")),
    MYACCOUNT_BUTTON(By.xpath("//*[@class='ico-account']")),
    LOGIN_BUTTON(By.cssSelector("button.button-1.login-button"));
    private final By locator;
    LoginL(By locator){
        this.locator = locator;
    }


    public By by() {
        return this.locator;
    }
}
