package com.zerobank.pages;


import org.openqa.selenium.support.PageFactory;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountSummaryPage extends BasePage {
    @FindBy(xpath = "//a[text()='Savings'][1]")
    public WebElement savingsBtn;

    @FindBy(xpath = "//a[text()='Brokerage']")
    public WebElement BrokerageBtn;

    @FindBy(xpath = "//a[text()='Checking']")
    public WebElement CheckingBtn;

    @FindBy(xpath = "//a[text()='Credit Card']")
    public WebElement CreditCardBtn;

    @FindBy(xpath = "//a[text()='Loan']")
    public WebElement LoanBtn;



    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(), (Object)this);
    }
}