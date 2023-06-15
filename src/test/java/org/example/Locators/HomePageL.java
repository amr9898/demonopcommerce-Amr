package org.example.Locators;

import org.openqa.selenium.By;

public enum HomePageL {

    HOME_PAGE(By.xpath("//*[starts-with(@alt,'nopCommerce')]")),
    CURRENCY_LIST(By.xpath("//*[@id='customerCurrency']")),
    FEATURED_PRODUCTS_LIST(By.xpath("//*[@class='product-item']"));
    private final By locator;
    HomePageL(By locator){
        this.locator = locator;
    }


    public By by() {
        return this.locator;
    }
}
