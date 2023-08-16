package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;
import static org.example.Locators.HomePageL.*;


public class P03_homePage {
    private String item;
   private int match_item =0;
private int total= 0;
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
        this.item=item;
        Hooks.driver.findElement(ADD_ITEM.by()).sendKeys(item);
        Hooks.driver.findElement(SUBMIT_SEARCH.by()).click();

    }

    public int size_of_searched_results() {

        try {WebElement element = Hooks.driver.findElement(NEXT_PAGE_SEARCH.by());
            return count_total(element);}
        catch (org.openqa.selenium.NoSuchElementException e){
            List<WebElement> searchResults = Hooks.driver.findElements(SEARCHED_ITEM.by());
            check_product(searchResults);
            return total;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
public void check_product (List<WebElement> Results){

    String searchString = item;
    int count =Results.size();

    for (WebElement searchResult : Results) {
        String resultText = searchResult.getText().toLowerCase();

        if (resultText.contains(searchString.toLowerCase())) {

           match_item++;
        }
    }
    total+= count;



}
public void valid_item(){
    System.out.println(match_item );
    System.out.println(total);
        softAssert.assertEquals(match_item,total);
        softAssert.assertAll();
}
public void click_on_first_item(){

        Hooks.driver.findElement(FIRST_ITEM.by()).click();
    }

    public void check_result() {
        final Wait<WebDriver> wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class);
          wait.until(ExpectedConditions.presenceOfElementLocated(SKU_SEARCH_ITEM.by()));
        WebElement searchResult = Hooks.driver.findElement(SKU_SEARCH_ITEM.by());
            Assert.assertEquals(searchResult .getText(), item);


    }
    public int count_total(WebElement element) throws InterruptedException {
        while (true) {
            Thread.sleep(3000);
            List<WebElement> searchResults = Hooks.driver.findElements(ITEMS_NEXT_PAGE.by());
            int count = 0;
            count = searchResults.size();
            try {
                element.click();
                check_product(searchResults);

            } catch (StaleElementReferenceException e) {
                total += count;
                break;
            }
        }
        System.out.println(match_item);
        return total;
    }


}
