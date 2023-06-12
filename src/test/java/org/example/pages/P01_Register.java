package org.example.pages;


import org.example.stepDefs.Hooks;
import org.jetbrains.annotations.NotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.example.Locators.RegisterL.*;

public class P01_Register {

    //This function return register web element button on home page
    public WebElement go_to_register()
    {return Hooks.driver.findElement(REGISTER_BUTTON.by()) ;}

    //This function return gender radio button web element button on home page
    public WebElement select_gender( String type) {
        if(type.equals("male")){
            return Hooks.driver.findElement(MALE_RADIO_BUTTON.by()) ;
        }else if (type.equals("female")){
            return Hooks.driver.findElement(FEMALE_RADIO_BUTTON.by()) ;
        }

        return null;

    }

    public void add_firstname_and_lastname(String first_name, String last_name)
    {
        Hooks.driver.findElement(FIRSTNAME_FIELD.by()).sendKeys(first_name);
        Hooks.driver.findElement(LASTNAME_FIELD.by()).sendKeys(last_name);

    }
    public void enter_date_of_birth (@NotNull String date) throws InterruptedException {
        String [] date_spliter= date.split("/");
        int container ;
        for (int i = 0; i < 3; i++) {
            container= Integer.parseInt(date_spliter[i]);
            if (i==0){
                    WebElement dropdown = Hooks.driver.findElement(DAY_FIELD.by());
                    if (0<container&&container<=getsize(dropdown)){
                        Select select= new Select(dropdown);
                        select.selectByVisibleText(date_spliter[i]);
                    }

            } else if (i==1 ){
                WebElement dropdown = Hooks.driver.findElement(MONTH_FIELD.by());
                if (0<container&&container<=getsize(dropdown)){
                    Select select= new Select(dropdown);
                    select.selectByIndex(container);
                }

            }else if (i==2 ){
                WebElement dropdown = Hooks.driver.findElement(YEAR_FIELD.by());
                if (1913<container&&container<=getsize(dropdown)){
                    Select select= new Select(dropdown);
                    select.selectByVisibleText(date_spliter[i]);
                    Thread.sleep(5000);
                }



            }


        }

    }
    private int getsize(WebElement dropdown){
        Select select= new Select(dropdown);
        List<WebElement> options = select.getAllSelectedOptions();
        return options.size();
    }
    public WebElement add_field(@NotNull String condition) {
        return switch (condition) {
            case "Email" -> Hooks.driver.findElement(EMAIL_FIELD.by());
            case "Company" -> Hooks.driver.findElement(COMPANY_FIELD.by());
            case "Password" -> Hooks.driver.findElement(PASSWORD_FIELD.by());
            case "Confirm password"->Hooks.driver.findElement(CONFIRMPASSWORD_FIELD.by());
            default -> null;
        };
    }
    public WebElement register() {
        return Hooks.driver.findElement(REGISTERBUTTON_FIELD.by());

    }

    public String get_color() {
        WebElement eleSearch = Hooks.driver.findElement(ASSERTION_TEXT.by());

        String rgbFormat = eleSearch.getCssValue("color");

        System.out.println(rgbFormat);     //In RGB Format the value will be print => rgba(254, 189, 105, 1)

//        String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
//        System.out.println(hexcolor);// Output of Hex code will be  => #febd69

        return rgbFormat;
    }

}
