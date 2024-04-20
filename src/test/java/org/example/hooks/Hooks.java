package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.UI.core.Base;

import static org.example.UI.utils.ReportScreenShots.takeScreenshotForReport;

public class Hooks extends Base {
    @Before
    public void setup(){
        initialize();
    }
    @After
    public void takeScreenshotOnFailure(Scenario scenario){
        if(scenario.isFailed()){
            takeScreenshotForReport(scenario);
        }
        else{
            takeScreenshotForReport(scenario);
        }
        driver.close();
    }
//    @AfterStep
//    public void takeScreenshot(Scenario scenario){
//        takeScreenshotForReport(scenario);
//    }
}
