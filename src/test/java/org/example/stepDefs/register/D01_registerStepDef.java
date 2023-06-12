package org.example.stepDefs.register;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    P01_Register register = new P01_Register();
    String condition;
    SoftAssert softAssert= new SoftAssert();
    @Given("user go to register page")
    public void userGoToRegisterPage() {register.go_to_register().click();}

    @When("user select gender {string}")
    public void userSelectGenderType(String type)  {

        register.select_gender(type).click();
    }



    @And("user enter {string}and{string}")
    public void add_firstname_And_lastname(String first_name, String last_name)  {
        register.add_firstname_and_lastname(first_name,last_name);

    }


    @And("user enter date of birth {string}")
    public void user_Enter_Date_Of_Birth(String date_of_birth) throws InterruptedException {
        register.enter_date_of_birth(date_of_birth);

    }

    @And("user enter email {string} field")
    public void userEnterEmail(String Email) {
        condition="Email";
        register.add_field(condition).sendKeys(Email);

    }

    @And("user enter company name {string} field")
    public void userEnterCompanyNameField(String company) {
        condition="Company";
        register.add_field(condition).sendKeys(company);

    }

    @And("user fills Password fields {string} and confirm")
    public void userFillsPasswordFieldsAndConfirm(String password)  {
        condition="Password";
        register.add_field(condition).sendKeys(password);
        condition= "Confirm password";
        register.add_field(condition).sendKeys(password);

    }

    @Then("user clicks on register button")
    public void userClicksOnRegisterButton() {
        register.register().click();
    }

    @And("success message is displayed")
    public void successMessageIsDisplayed() {

       softAssert.assertEquals(register.get_color() , "rgba(76, 177, 124, 1)");
       softAssert.assertAll();
    }
}
