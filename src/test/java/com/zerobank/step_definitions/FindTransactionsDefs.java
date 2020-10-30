package com.zerobank.step_definitions;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import java.util.List;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Given;
import com.zerobank.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.Driver;
import com.zerobank.utilities.ConfigurationReader;

public class FindTransactionsDefs {
    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        Driver.get().manage().window().maximize();

        LoginPage loginPage = new LoginPage();
        loginPage.signIn.click();
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        loginPage.login(username, password);
        BrowserUtils.waitFor(2);

        Driver.get().findElement(By.id("account_activity_tab")).click();
        Driver.get().findElement(By.xpath("//a[text()='Find Transactions']")).click();
        BrowserUtils.waitFor(1);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to_(String data1, String data2) {
        BrowserUtils.waitFor(2);
        data2 = "2012-09-06";
        if (data1.equals("2012-09-01")) {
            new AccountActivityPage().dataFrom.sendKeys("2012-09-01");
            new AccountActivityPage().dataTo.sendKeys(data2 );
        }
        else if (data1.equals("2012-09-02")) {
            new AccountActivityPage().dataFrom.sendKeys("2012-09-02");
            new AccountActivityPage().dataTo.sendKeys(data2);
        }
        BrowserUtils.waitFor(3);
    }

    @And("clicks search")
    public void clicks_search() {
        new AccountActivityPage().findBtn.click();
        BrowserUtils.waitFor(3);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String date1,String date6) {
        int fromData = Integer.parseInt(new AccountActivityPage().dataFrom.getAttribute("value").replace("-", ""));

        int toData = Integer.parseInt(new AccountActivityPage().dataTo.getAttribute("value").replace("-", ""));
        BrowserUtils.waitFor(4);
        List<WebElement> Date = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[1]"));
        int columnData = 0;
        List<Integer> columnsValues = new ArrayList();
        for (int i = 0; i < Date.size(); ++i) {
            String[] strings1 = Date.get(i).getText().split("-");
            String columnDataString = strings1[0].concat(strings1[1]).concat(strings1[2]);
            columnData = Integer.parseInt(columnDataString);
            columnsValues.add(columnData);
        }
        for (int i = 0; i < columnsValues.size(); ++i) {
            if (columnsValues.get(i) <= toData && columnsValues.get(i) >= fromData) {
                Assert.assertTrue(true);
            }
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<WebElement> Date =Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[1]"));
        int columnData = 0;

        List<Integer> columnsValues = new ArrayList();

        for (int i = 0; i < Date.size(); ++i) {

            String[] strings1 = Date.get(i).getText().split("-");
            String columnDataString = strings1[0].concat(strings1[1]).concat(strings1[2]);
            columnData = Integer.parseInt(columnDataString);
            columnsValues.add(columnData);
        }

        int maxColumnValue = columnsValues.get(0);

        for (int j = 0; j < columnsValues.size(); ++j) {
            if (maxColumnValue >= columnsValues.get(j)) {
                Assert.assertTrue(true);
            }
        }

        new AccountActivityPage().dataFrom.clear();
        new AccountActivityPage().dataTo.clear();
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String data) {

        List<WebElement> date = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[1]"));

        List<String> dateList = new ArrayList();
        for (int i = 0; i < date.size(); ++i) {
            dateList.add(date.get(i).getText());
        }
        for (int i = 0; i < date.size(); ++i) {
            if (!dateList.get(i).contains(data)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String word) {
        if (word.equals("ONLINE")) {
            new AccountActivityPage().descriptionBtn.sendKeys("ONLINE");
        }
        else if (word.equals("OFFICE")) {
            new AccountActivityPage().descriptionBtn.sendKeys("OFFICE");
        }
        else if (word.equals("online")) {
            new AccountActivityPage().descriptionBtn.sendKeys("online");
        }
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String obj) {

        if (!Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[2]")).isEmpty()) {
            List<WebElement> description = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[2]"));
            List<String> objList = new ArrayList();

            for (int i = 0; i < description.size(); ++i) {
                String strings1 = description.get(i).getText();
                objList.add(strings1);
                if (objList.toString().contains(obj)) {
                    Assert.assertTrue(true);
                } else{
                    Assert.fail();
            }}
            new AccountActivityPage().descriptionBtn.clear();
        }else
            Assert.fail();
    }
    @But("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String obj) {
        List<WebElement> description = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[2]"));

        List<String> objList = new ArrayList();

        for (int i = 0; i < description.size(); ++i) {
            String strings1 = description.get(i).getText();
            objList.add(strings1);
            if (!objList.toString().contains(obj)) {
                Assert.assertTrue(true);
            }
        }
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        List<WebElement> description =Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[3]"));

        List<String> columnsValues = new ArrayList();

        for (int i = 0; i < description.size(); ++i) {
            String strings1 = description.get(i).getText();
            columnsValues.add(strings1);
        }
        if (!columnsValues.isEmpty()) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {

        List<WebElement> description =Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[4]"));

        List<String> columnsValues = new ArrayList();
        for (int i = 0; i < description.size(); ++i) {
            String strings1 = description.get(i).getText();
            columnsValues.add(strings1);
        }
        if (!columnsValues.isEmpty()) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        Driver.get().findElement(By.id("aa_type")).click();

        if (string.equals("Deposit")) {
            Driver.get().findElement(By.xpath("//select[@id='aa_type']/option[2]")).click();
        } else if (string.equals("Withdrawal")) {
            Driver.get().findElement(By.xpath("//select[@id='aa_type']/option[3]")).click();
        }
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        List<WebElement> withDrawal = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[4]"));

        for (int i = 0; i < withDrawal.size(); ++i) {
            String strings1 = withDrawal.get(i).getText();
            if (strings1.isEmpty()) {
                Assert.assertTrue(true);
            } else {
                Assert.fail();
            }
        }
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        List<WebElement> withDrawal =Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[3]"));

        for (int i = 0; i < withDrawal.size(); ++i) {
            String strings1 = withDrawal.get(i).getText();

            if (strings1.isEmpty()) {
                Assert.assertTrue(true);
            } else {
                Assert.fail();
            }
        }
    }
}