package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Login;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    P02_Login login=new P02_Login();
    private SoftAssert softAssert= new SoftAssert();
    private WebElement cheack;
    @Given("user go to login page")
    public void userGoToLoginPage()  {login.go_to_login().click();}

    @When("user login with valid Email{string}and Password {string}")
    public void userLoginWithValidEmailAndPassword(String Email, String Password) {
        System.out.println(Password);
         login.login(Email,Password);

    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        login.click_on_login().click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        softAssert.assertTrue(login.my_account().isDisplayed(),"wrong valid");
        softAssert.assertEquals(login.get_url(),"https://demo.nopcommerce.com/");
        softAssert.assertAll();
    }

    @When("user login with invalid Email{string}and Password {string}")
    public void userLoginWithInvalidEmailAndPassword(String email, String password) {
        login.login(email,password);

    }

    @Then("user can't login to the system successfully")
    public void userCanTLoginToTheSystemSuccessfully() {
        softAssert.assertTrue(login.error_message_for_invalid_login().contains("Login was unsuccessful."),"negative result");
        softAssert.assertEquals(login.get_color() , "#e4434b");
        softAssert.assertAll();


    }
}
