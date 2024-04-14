package org.example.UI.actions;

import org.openqa.selenium.WebDriver;

public class Navigate {
    public static WebDriver driver;

    public Navigate(WebDriver driver){

        Navigate.driver =driver;
    }

    public boolean NavigateToSite(String url){
        driver.get(url);
        return true;
    }
}
