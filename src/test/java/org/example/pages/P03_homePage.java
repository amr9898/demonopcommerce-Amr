package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
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

    public void add_item_to_search_field( String item ){
        Hooks.driver.findElement(By.xpath("//*[@id='small-searchterms']")).sendKeys(item);
        Hooks.driver.findElement(By.xpath("//*[@type='submit']")).click();

    }

    public int size_of_searched_results() {

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='product-item']")));

        int totalCount = 0;

        while (true) {

            List<WebElement> searchResults = Hooks.driver.findElements(By.xpath("//*[@class='product-item']"));

            int count = searchResults.size();
            totalCount += count;

            WebElement element=Hooks.driver.findElement(By.xpath("//*[@class='next-page']"));

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='next-page']")));
    if (element.isEnabled()) {

        element.click();


        wait.until(ExpectedConditions.stalenessOf(searchResults.get(0)));


    } else {
        break;
    }}
        return totalCount;
    }


}
