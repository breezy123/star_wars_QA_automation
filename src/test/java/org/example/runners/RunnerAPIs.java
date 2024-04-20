package org.example.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
//        monochrome = true,
        //dryRun = false,
        features = {"src/test/resources/features"},
        tags="@api",
        glue = {"org.example.stepDefs.API"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class RunnerAPIs extends AbstractTestNGCucumberTests{
}
