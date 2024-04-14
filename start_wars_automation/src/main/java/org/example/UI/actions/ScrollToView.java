package org.example.UI.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

//import static org.kinetickskunk.selenium.core.BaseClass.waits;

public class ScrollToView {

    public static WebDriver driver;

    public ScrollToView(WebDriver driver){

        ScrollToView.driver =driver;

    }

    public boolean ScrollToElementByxPath(String xPath){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try
        {
            WebElement element = driver.findElement(By.xpath(xPath));
            js.executeScript("arguments[0].scrollIntoView();", element);
            return true;
        }
        catch (Exception ex){
            System.out.println("[ERROR Scrolling to Element]\t"+ Arrays.toString(ex.getStackTrace()));
            return false;
        }
    }

}
