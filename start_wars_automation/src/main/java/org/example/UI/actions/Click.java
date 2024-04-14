package org.example.UI.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class Click {

    public static WebDriver driver;

    public Click(WebDriver driver){
        Click.driver =driver;
    }

    public boolean ClickElementByxPath(String xPath){
        try
        {
            WebElement element = driver.findElement(By.xpath(xPath));
            element.click();
            return true;
        }
        catch (Exception ex){
            System.out.println("[ERROR Clicking]\t"+ Arrays.toString(ex.getStackTrace()));
            return false;
        }
    }
}
