package org.example.UI.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class SeleniumDriver {
    public enum BrowserType {
        CHROME, MS_EDGE} //choosing browser type
    private WebDriver driver;
    private BrowserType currentBrowser;
    private static final String rootDirectory = System.getProperty("user.dir");

    public WebDriver getDriver() {
        return driver;
    }

    public SeleniumDriver(BrowserType browser) {
        this.currentBrowser = browser;
        launchDriver();
    }

    public void launchDriver() {
        try {
            Properties p = new Properties();
            p.load(Files.newInputStream(Paths.get(rootDirectory + "\\src\\test\\resources\\config\\config.props")));
            switch (currentBrowser) {
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    WebDriverManager.chromedriver().setup();
                    System.setProperty(p.getProperty("WebDriverchrome"),p.getProperty("Chrome_Driver"));
                    chromeOptions.addArguments("--headless=new");
                    this.driver = new ChromeDriver(chromeOptions);
                    break;
                case MS_EDGE:
                    EdgeOptions edgeOptions = new EdgeOptions();
                    WebDriverManager.edgedriver().setup();
                    System.setProperty(p.getProperty("WebDriver_MS_Edge"),p.getProperty("MS_Edge_Driver"));
                    edgeOptions.addArguments("--guest");
                    edgeOptions.addArguments("--remote-allow-origins=*");
                    edgeOptions.addArguments("-headless");
                    this.driver = new EdgeDriver(edgeOptions);
                    break;
                default:
                    System.err.println("Invalid Browser");
                    break;
            }
        } catch (Exception ex) {
            System.err.println("[Error]: Error Launching driver " + ex.getMessage());
        }

        this.driver.manage().window().maximize();
        this.driver.manage().deleteAllCookies();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void goToWebSite(String url){
        driver.get(url);
    }
}
