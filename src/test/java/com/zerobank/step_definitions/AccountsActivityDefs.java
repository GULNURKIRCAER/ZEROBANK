package com.zerobank.step_definitions;

import io.cucumber.java.en.And;
import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.Driver;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class AccountsActivityDefs {
    @Given("the user is logged in")
    public void the_user_is_logged_in()  {

        String url = ConfigurationReader.get("url");

        Driver.get().get(url);

        LoginPage loginPage = new LoginPage();

        loginPage.signIn.click();

        BrowserUtils.waitFor(2);

        Driver.get().findElement(By.id("user_login")).sendKeys("username");
        Driver.get().findElement(By.id("user_password")).sendKeys("password");

        if(loginPage.userName.getAttribute("value").equals("username") || loginPage.password.getAttribute("value").equals("password")) {
            Driver.get().findElement(By.name("submit")).click();
        }else  if(!loginPage.userName.getAttribute("value").equals("username") || !loginPage.password.getAttribute("value").equals("password")){
            Assert.assertTrue(loginPage.alert.isDisplayed());
        }
    }
    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        BrowserUtils.waitFor(2);
        //get the list of webelement and convert them to list of string and assert
        List<WebElement> actualOptions = Driver.get().findElements(By.xpath("//div[@class='span12']/div/h2"));
        List<String> columnsValues = new ArrayList<>();
        for (int i = 0; i < actualOptions.size(); ++i) {
            columnsValues.add(actualOptions.get(i).getText());
        }
        Assert.assertEquals(menuOptions, columnsValues);
    }
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String expectedPage)  {

        BrowserUtils.waitFor(2);
        if (expectedPage.equals("Savings")) {
            new AccountSummaryPage().savingsBtn.click();
        }
        else if (expectedPage.equals("Brokerage")) {
            new AccountSummaryPage().BrokerageBtn.click();
        }
        else if (expectedPage.equals("Checking")) {
            new AccountSummaryPage().CheckingBtn.click();
        }
        else if (expectedPage.equals("Credit Card")) {
            new AccountSummaryPage().CreditCardBtn.click();
        }
        else if (expectedPage.equals("Loan")) {
            new AccountSummaryPage().LoanBtn.click();
        }
        BrowserUtils.waitFor(2);
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed()  {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Zero - Account Activity", actualTitle);
    }

    @Then("the Account Summary page should be displayed")
    public void the_Account_Summary_page_should_be_displayed()  {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Zero - Account Summary",actualTitle);
    }

    @And("Account drop down should have {string} selected")
    public void the_user_enters_the_sales_manager_information(String expectedPage)  {

        if (expectedPage.equals("Savings")) {
            Assert.assertTrue(new AccountActivityPage().savingsBtn.isSelected());
        }
        else if (expectedPage.equals("Brokerage")) {
            Assert.assertTrue(new AccountActivityPage().BrokerageBtn.isSelected());
        }
        else if (expectedPage.equals("Checking")) {
            Assert.assertTrue(new AccountActivityPage().CheckingBtn.isSelected());
        }
        else if (expectedPage.equals("Credit card")) {
            Assert.assertTrue(new AccountActivityPage().CreditCardBtn.isSelected());
        }
        else if (expectedPage.equals("Loan")) {
            Assert.assertTrue(new AccountActivityPage().LoanBtn.isSelected());
        }
    }
}