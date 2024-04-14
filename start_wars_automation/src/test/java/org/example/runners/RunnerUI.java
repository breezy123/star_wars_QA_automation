package org.example.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
//        monochrome = true,
        //dryRun = false,
        features = {"src/test/resources/features"},
        tags="@ui",
        glue = {"org.example"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class RunnerUI extends AbstractTestNGCucumberTests{
}
