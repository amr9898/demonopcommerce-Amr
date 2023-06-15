package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D03_currenciesStepDef {
    P03_homePage home = new P03_homePage();
    @Given("user navigate to home page")
    public void userGoToLoginPage()  {home.navigate_to_homepage().click();}


    @When("user Select {string} currency from the dropdown list on the top left of home page")
    public void user_Select_Currency_From_TheDropdownList(String currency) {
        home.select_currency(currency);
    }


    @Then("featured products currency changed successfully and check by currency symbol {string}")
    public void CheckByCurrencySymbol(String currency_symbol) {
        home.check_currency_list(home.featured_products(),currency_symbol);
    }
}
