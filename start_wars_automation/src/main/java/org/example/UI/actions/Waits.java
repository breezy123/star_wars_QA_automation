package org.example.UI.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class Waits {

    public static WebDriver driver;

    public Waits(){}
    public Waits(WebDriver driver){
        Waits.driver =driver;
    }

    public void setDriver(WebDriver driver){ Waits.driver =driver;}

    public boolean waitForElementByXpath(String xPath){
        try
        {
//            Thread.sleep(5);
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            ((JavascriptExecutor)driver).executeScript("window.focus();");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
            return true;
        }
        catch (Exception ex){
            System.out.println("[ERROR]\t"+ Arrays.toString(ex.getStackTrace()));
            return false;
        }
    }
}
