package com.zerobank.utilities;


import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Driver
{
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver get() {
        if (Driver.driver == null) {
            final String value;
            final String browser = value = ConfigurationReader.get("browser");
            switch (value) {
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    Driver.driver = (WebDriver)new ChromeDriver();
                    break;
                }
                case "chrome-headless": {
                    WebDriverManager.chromedriver().setup();
                    Driver.driver = (WebDriver)new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    Driver.driver = (WebDriver)new FirefoxDriver();
                    break;
                }
                case "firefox-headless": {
                    WebDriverManager.firefoxdriver().setup();
                    Driver.driver = (WebDriver)new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                }
                case "ie": {
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    }
                    WebDriverManager.iedriver().setup();
                    Driver.driver = (WebDriver)new InternetExplorerDriver();
                    break;
                }
                case "edge": {
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Edge");
                    }
                    WebDriverManager.edgedriver().setup();
                    Driver.driver = (WebDriver)new EdgeDriver();
                    break;
                }
                case "safari": {
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your OS doesn't support Safari");
                    }
                    WebDriverManager.getInstance((Class)SafariDriver.class).setup();
                    Driver.driver = (WebDriver)new SafariDriver();
                    break;
                }
            }
        }
        return Driver.driver;
    }

    public static void closeDriver() {
        if (Driver.driver != null) {
            Driver.driver.quit();
            Driver.driver = null;
        }
    }
}