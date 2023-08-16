package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D04_searchStepDef {
    P03_homePage home = new P03_homePage();
    @When("I add product name {string}and  click")
    public void add_product(String product )  {
        home.add_item_to_search_field(product);

    }

    @Then("user find size of all relevant results related to that name")
    public void userFindAllRelevantResultsRelatedToThatName() throws InterruptedException {

        System.out.println("number of searched results = " + home.size_of_searched_results());


    }



    @And("check that results that contain searched word")
    public void checkThatResultsThatContainSearchedWord() {
        home.valid_item();
    }

    @When("I add  sku product name {string}and  click")
    public void iAddSkuProductNameAndClick(String product) {
        home.add_item_to_search_field(product);
    }

    @Then("after searching click on first item")
    public void afterSearchingClickOnFirstItem() {
        home.click_on_first_item();

    }

    @And("check that results that contain searched sku word")
    public void checkThatResultsThatContainSearchedSkuWord() {
        home.check_result();

    }
}
