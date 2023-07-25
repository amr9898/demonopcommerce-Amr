package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D04_searchStepDef {
    P03_homePage home = new P03_homePage();
    @When("I add product name {string}and  click")
    public void add_product(String product )  {
        home.add_item_to_search_field(product);

    }

    @Then("user find size of all relevant results related to that name")
    public void userFindAllRelevantResultsRelatedToThatName() {

        System.out.println(home.size_of_searched_results());


    }

    @And("check that url  contains {string}")
    public void checkThatUrlContains(String arg0) {
    }
}
