package com.zerobank.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
         "html:target/default-html-reports" },
        features = "src/test/resources/features" ,
        glue = "com/zerobank/step_definitions" ,
        dryRun = false,
        tags = "@login"
)
        public class CukesRunner{
}