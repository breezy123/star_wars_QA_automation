package org.example.UI.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
    WebDriver driver;
    @FindBy(xpath = "//th[normalize-space()='Title']")
    private WebElement titleField;
    @FindBy(xpath = "//a[@class='underline font-medium']")
    private WebElement allMovies;
    public MenuPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public  void NavigateToSite(String url){
        try{
            driver.get(url);
        }
        catch(Exception ex){
            System.err.println("[Error] Navigation error:"+ex.getMessage());
        }
    }

//    public boolean click
}
