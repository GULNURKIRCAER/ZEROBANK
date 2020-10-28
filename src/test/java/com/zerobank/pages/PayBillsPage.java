package com.zerobank.pages;

import org.openqa.selenium.support.PageFactory;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class PayBillsPage extends BasePage
{
    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    public PayBillsPage() {
        PageFactory.initElements(Driver.get(), (Object)this);
    }
}