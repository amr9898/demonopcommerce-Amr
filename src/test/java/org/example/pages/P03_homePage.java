package org.example.pages;

import org.example.Locators.HomePageL;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.example.Locators.HomePageL.*;


public class P03_homePage {
    private SoftAssert softAssert= new SoftAssert();
    public WebElement navigate_to_homepage()
    {return Hooks.driver.findElement(HOME_PAGE.by()) ;}

    public void select_currency(String currency) {
        WebElement dropdown = Hooks.driver.findElement(CURRENCY_LIST.by());
        Select select= new Select(dropdown);
        select.selectByVisibleText(currency);

    }

    public List<WebElement> featured_products() {
        List<WebElement> featured_products =Hooks.driver.findElements(FEATURED_PRODUCTS_LIST.by());
        return featured_products;
    }

    public  void check_currency_list(List<WebElement>products,String check_value) {
        for (int i = 0; i < products.size() ; i++){

            System.out.println(i);
            System.out.println(products.get(i).getText());
            softAssert.assertTrue(products.get(i).getText().contains(check_value));

        }
        softAssert.assertAll();

    }
}
