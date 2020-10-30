package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.support.PageFactory;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class LoginPage
{
    @FindBy(id = "signin_button")
    public WebElement signIn;

    @FindBy(id = "user_login")
    public WebElement userName;

    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement submit2;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement alert;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddress;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetails;

    public LoginPage() {
        PageFactory.initElements(Driver.get(), (Object)this);
    }

    public void login(String userName,String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        BrowserUtils.waitFor(2);
        this.submit.click();
        BrowserUtils.waitFor(3);
    }
    public void NewPayee(String userName,String password) {
        this.payeeName.sendKeys(userName);
        this.payeeAddress.sendKeys(password);
        BrowserUtils.waitFor(1);
    }
    public void NewPayee2(String userName,String password) {
        this.payeeAccount.sendKeys(userName);
        this.payeeDetails.sendKeys(password);
        BrowserUtils.waitFor(2);
        this.submit2.click();

    }

}