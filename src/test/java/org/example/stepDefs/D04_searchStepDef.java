package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D04_searchStepDef {
    P03_homePage home = new P03_homePage();
    @When("I add product name {string}and  click")
    public void add_product(String product )  {


    }

    @Then("user find all relevant results related to that name")
    public void userFindAllRelevantResultsRelatedToThatName() {
    }
}
