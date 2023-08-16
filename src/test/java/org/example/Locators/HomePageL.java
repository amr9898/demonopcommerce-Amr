package org.example.Locators;

import org.openqa.selenium.By;

public enum HomePageL {

    HOME_PAGE(By.xpath("//*[starts-with(@alt,'nopCommerce')]")),
    CURRENCY_LIST(By.xpath("//*[@id='customerCurrency']")),
    FEATURED_PRODUCTS_LIST(By.xpath("//*[@class='product-item']")),
    ADD_ITEM(By.xpath("//*[@id='small-searchterms']")),
    SUBMIT_SEARCH( By.xpath("//*[@type='submit']")),
    NEXT_PAGE_SEARCH(By.xpath("//*[@class='next-page']")),
    SEARCHED_ITEM(By.xpath("//*[@class='item-box']")),
    FIRST_ITEM(By.xpath("//*[@class='product-item']")),
    SKU_SEARCH_ITEM(By.xpath("//*[contains(@id, 'sku-')]")),
    ITEMS_NEXT_PAGE(By.xpath("//*[@class='item-box']"));



    private final By locator;
    HomePageL(By locator){
        this.locator = locator;
    }


    public By by() {
        return this.locator;
    }
}
