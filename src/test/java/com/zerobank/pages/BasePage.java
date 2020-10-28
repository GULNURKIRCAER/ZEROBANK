package com.zerobank.pages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import com.zerobank.utilities.BrowserUtils;
import java.util.function.Function;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import java.util.List;

public abstract class BasePage
{
    @FindBy(css = "span.title-level-1")
    public List<WebElement> menuOptions;
    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;
    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;
    @FindBy(css = "#user-menu > a")
    public WebElement userName;
    @FindBy(linkText = "Logout")
    public WebElement logOutLink;
    @FindBy(linkText = "My User")
    public WebElement myUser;

    public BasePage() {
        PageFactory.initElements(Driver.get(), (Object)this);
    }

    public String getPageSubTitle() {
        this.waitUntilLoaderScreenDisappear();
        return this.pageSubTitle.getText();
    }

    public void waitUntilLoaderScreenDisappear() {
        try {
            final WebDriverWait wait = new WebDriverWait(Driver.get(), 5L);
            wait.until((Function)ExpectedConditions.invisibilityOf(this.loaderMask));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUserName() {
        this.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(this.userName, 5);
        return this.userName.getText();
    }

    public void logOut() {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(this.userName);
        BrowserUtils.clickWithJS(this.logOutLink);
    }

    public void goToMyUser() {
        this.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(this.userName, 5).click();
        BrowserUtils.waitForClickablility(this.myUser, 5).click();
    }

    public void navigateToModule(final String tab, final String module) {
        final String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
        final String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            final WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200L).doubleClick(tabElement).build().perform();
        }
        catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5L);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        }
        catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)), 5);
        }
    }
}