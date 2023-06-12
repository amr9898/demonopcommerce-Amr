package org.example.Locators;

import org.openqa.selenium.By;

public enum RegisterL {
    REGISTER_BUTTON(By.xpath("//*[@class='ico-register']")),
   MALE_RADIO_BUTTON(By.xpath("//*[@id='gender-male']")),
    FEMALE_RADIO_BUTTON(By.xpath("//*[@id='gender-female']")),
    FIRSTNAME_FIELD(By.xpath("//*[@id='FirstName']")),
    LASTNAME_FIELD(By.xpath("//*[@id='LastName']")),
    DAY_FIELD(By.xpath("//*[@name='DateOfBirthDay']")),
    MONTH_FIELD(By.xpath("//*[@name='DateOfBirthMonth']")),
    YEAR_FIELD(By.xpath("//*[@name='DateOfBirthYear']")),
    EMAIL_FIELD(By.xpath("//*[@id='Email']")),
    COMPANY_FIELD(By.xpath("//*[@id='Company']")),
    PASSWORD_FIELD(By.xpath("//*[@id='Password']")),
    CONFIRMPASSWORD_FIELD(By.xpath("//*[@id='ConfirmPassword']")),
    REGISTERBUTTON_FIELD(By.xpath("//*[@id='register-button']")),
    ASSERTION_TEXT(By.xpath("//*[@class='result']"));


    private final By locator;
    RegisterL(By locator){
        this.locator = locator;
    }


    public By by() {
        return this.locator;
    }

}
