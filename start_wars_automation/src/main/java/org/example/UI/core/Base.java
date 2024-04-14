package org.example.UI.core;

import org.example.UI.actions.*;
import org.example.UI.driver.SeleniumDriver;
import org.openqa.selenium.WebDriver;

public class Base {
    public static WebDriver driver;
    public static SeleniumDriver seleniumDriverInstance;
    public static SeleniumDriver.BrowserType browserType;
    public static Navigate navigate;
    public static Click click;
    public static Tables tables;
    public static ScrollToView scrollToView;
    public static Waits waits;

    public static void initialize(){
        browserType = SeleniumDriver.BrowserType.MS_EDGE;
        seleniumDriverInstance = new SeleniumDriver(browserType);
        driver = seleniumDriverInstance.getDriver();

        navigate = new Navigate(driver);
        click = new Click(driver);
        tables = new Tables(driver);
        scrollToView = new ScrollToView(driver);
        waits = new Waits(driver);
    }

}
