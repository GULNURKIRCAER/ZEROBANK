package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Map;

public class AddNewPayeeDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        String url = ConfigurationReader.get("url");

        Driver.get().get(url);

        LoginPage loginPage = new LoginPage();

        loginPage.signIn.click();

//        String username = ConfigurationReader.get("username");
//        String password = ConfigurationReader.get("password");

        Driver.get().findElement(By.id("user_login")).sendKeys("username");
        Driver.get().findElement(By.id("user_password")).sendKeys("password");

        if(loginPage.userName.getAttribute("value").equals("username") || loginPage.password.getAttribute("value").equals("password")) {
            Driver.get().findElement(By.name("submit")).click();
        }else  if(!loginPage.userName.getAttribute("value").equals("username") || !loginPage.password.getAttribute("value").equals("password")){
            Assert.assertTrue(loginPage.alert.isDisplayed());
        }
            Driver.get().findElement(By.xpath("//a[text()='Pay Bills']")).click();

            Driver.get().findElement(By.xpath("//a[text()='Add New Payee']")).click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> userInfo) {

        BrowserUtils.waitFor(1);
        new LoginPage().NewPayee(userInfo.get("Payee Name"),userInfo.get("Payee Address"));

        new LoginPage().NewPayee2(userInfo.get("Account"),userInfo.get("Payee details"));

    }
    @Then("message The new payee The Law Offices of Hyde,Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        BrowserUtils.waitFor(1);
        Assert.assertEquals("The new payee The Law Offices of Hyde,Price & Scharks was successfully created.",Driver.get().findElement(By.id("alert_content")).getText());
    }


}
