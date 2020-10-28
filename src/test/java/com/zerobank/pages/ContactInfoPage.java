package com.zerobank.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class ContactInfoPage extends BasePage
{
    @FindBy(className = "user-name")
    public WebElement contactFullName;
    @FindBy(css = "a.phone")
    public WebElement phone;
    @FindBy(css = "a.email")
    public WebElement email;
}
