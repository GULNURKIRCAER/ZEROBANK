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

    @FindBy(name = "submit")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement alert;

    public LoginPage() {
        PageFactory.initElements(Driver.get(), (Object)this);
    }

    public void login(String userName,String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.submit.click();
        BrowserUtils.waitFor(3);
    }
}