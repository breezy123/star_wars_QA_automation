package org.example.UI.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tables {
    public static WebDriver driver;
    List<String> tableData;
    public Tables(WebDriver driver){
        Tables.driver =driver;
    }

    public boolean getColumnDataByXpath(String xPath){
        try
        {
            tableData = new ArrayList<String>();
            List<WebElement> tableColumn = driver.findElements(By.xpath(xPath));

            for (WebElement webElement : tableColumn) {
                tableData.add(webElement.getText());
            }
            return true;
        }
        catch (Exception ex){
            System.out.println("[ERROR Retrieving Column Data]\t"+ Arrays.toString(ex.getStackTrace()));
            return false;
        }
    }

    public boolean getLastIndexValue(String movieTitle){

        try{
            int lastIndex = tableData.lastIndexOf(movieTitle);
            System.out.println("'Movie' "+movieTitle+" is at Index "+lastIndex);
            return true;
        }
        catch(Exception ex){
            System.out.println("[ERROR] Failed to Retrieve Last Index value. "+ex.getMessage());
            return false;
        }
    }
}
