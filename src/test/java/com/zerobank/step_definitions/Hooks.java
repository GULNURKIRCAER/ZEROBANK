package com.zerobank.step_definitions;

import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;

public class Hooks
{
    @Before
    public void setUp() {
        System.out.println("\tthis is coming from BEFORE");
    }

    @After
    public void tearDown(final Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = (byte[])((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        Driver.closeDriver();
    }

    @Before("@db")
    public void setUpdb() {
        System.out.println("\tconnecting to database...");
    }

    @After("@db")
    public void closeDb() {
        System.out.println("\tdisconnecting to database...");
    }
}


