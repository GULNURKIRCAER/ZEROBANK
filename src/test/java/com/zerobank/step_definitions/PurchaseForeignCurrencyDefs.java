package com.zerobank.step_definitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PurchaseForeignCurrencyDefs {
        WebDriver driver;
    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginPage = new LoginPage();
        loginPage.signIn.click();

        Driver.get().findElement(By.id("user_login")).sendKeys("username");
        Driver.get().findElement(By.id("user_password")).sendKeys("password");

        if(loginPage.userName.getAttribute("value").equals("username") || loginPage.password.getAttribute("value").equals("password")) {
            Driver.get().findElement(By.name("submit")).click();
        }else  if(!loginPage.userName.getAttribute("value").equals("username") || !loginPage.password.getAttribute("value").equals("password")){
            Assert.assertTrue(loginPage.alert.isDisplayed());
        }
        Driver.get().findElement(By.xpath("//a[text()='Pay Bills']")).click();

        Driver.get().findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> menuOptions) {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//select[@id='pc_currency']")).click();

        List<WebElement> actualOptions = Driver.get().findElements(By.xpath("//select[@id='pc_currency']/option"));
        List<String> columnsValues = new ArrayList<>();
        for (int i = 0; i < actualOptions.size(); ++i) {
            columnsValues.add(actualOptions.get(i).getText());
        }
        Assert.assertEquals(menuOptions, columnsValues);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.id("pc_amount")).sendKeys("10");

        BrowserUtils.waitFor(2);

        new LoginPage().submit2.click();

        BrowserUtils.waitFor(2);

        Alert alert=driver.switchTo().alert();
        BrowserUtils.waitFor(2);
        System.out.println(alert.getText());
        BrowserUtils.waitFor(2);
        alert.accept();


    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//select[@id='pc_currency']")).click();

        Driver.get().findElement(By.xpath("(//select[@id='pc_currency']/option)[3]")).click();

        BrowserUtils.waitFor(2);

        new LoginPage().submit2.click();

        BrowserUtils.waitFor(2);

        Alert alert=driver.switchTo().alert();
        BrowserUtils.waitFor(3);
        System.out.println(alert.getText());

        alert.accept();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = driver.switchTo().alert();
        BrowserUtils.waitFor(3);
        Assert.assertEquals(alert.getText(),"Please, ensure that you have filled all the required fields with valid values.");

        alert.accept();
    }
}
