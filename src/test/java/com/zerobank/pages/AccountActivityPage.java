package com.zerobank.pages;

        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.WebElement;

public class AccountActivityPage extends BasePage
{
    @FindBy(xpath = "//option[text()='Savings'][1]")
    public WebElement savingsBtn;

    @FindBy(xpath = "//option[text()='Brokerage']")
    public WebElement BrokerageBtn;

    @FindBy(xpath = "//option[text()='Checking']")
    public WebElement CheckingBtn;

    @FindBy(xpath = "//option[text()='Credit Card']")
    public WebElement CreditCardBtn;

    @FindBy(xpath = "//option[text()='Loan']")
    public WebElement LoanBtn;

    @FindBy(id = "aa_fromDate")
    public WebElement dataFrom;

    @FindBy(id = "aa_toDate")
    public WebElement dataTo;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findBtn;

    @FindBy(id = "aa_description")
    public WebElement descriptionBtn;
}



