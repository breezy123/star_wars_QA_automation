package org.example.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
//        monochrome = true,
        //dryRun = false,
        features = {"src/test/resources/features"},
        tags="@ui",
        glue = {"org.example"},
        plugin = {"json:target/RunCucumber/cucumber.json",
                "pretty","html:target/RunCucumber/OrangeCRM.html"}
)

@Test
public class RunnerUI extends AbstractTestNGCucumberTests{
}
