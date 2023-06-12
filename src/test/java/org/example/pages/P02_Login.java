package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.example.Locators.LoginL.*;
import static org.example.Locators.RegisterL.*;

public class P02_Login {


    public WebElement go_to_login()
    {return Hooks.driver.findElement(MAIN_PAGE_LOGIN_BUTTON.by()) ;}

    public void   login( String Email , String Password  ) {
        Hooks.driver.findElement(LOGIN_EMAIL_FIELD.by()).sendKeys(Email);
        System.out.println(Password);
        Hooks.driver.findElement(LOGIN_PASSWORD_FIELD.by()).sendKeys(Password);
        FluentWait waiit = new FluentWait(Hooks.driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        waiit.until(ExpectedConditions.presenceOfElementLocated(LOGIN_PASSWORD_FIELD.by()));


        }
    public WebElement click_on_login (){
        return Hooks.driver.findElement(LOGIN_BUTTON.by());
    }
    public String get_url(){
        return Hooks.driver.getCurrentUrl();
    }
    public WebElement my_account(){
        return Hooks.driver.findElement(MYACCOUNT_BUTTON.by());
    }


}
