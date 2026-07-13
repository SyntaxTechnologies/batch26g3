package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods extends pageInitialiser{

    public static WebDriver driver;

    public void openBrowser(){
        switch (ConfigReader.read("browser")){
            case "Chrome":
                driver = new ChromeDriver();
                break;

            case "Edge":
                driver=new EdgeDriver();
                break;

            case "FireFox":
                driver=new FirefoxDriver();
                break;
            case "Safari":
                driver=new SafariDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        initilizePageObjects();
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void sendText(String username, WebElement element){
            element.clear();
            element.sendKeys(username);
    }

    public WebDriverWait getwait(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(Constants.Explicit_Wait));
        return  wait;
    }


    public void waitForElementToBeClickAble(WebElement element){
        getwait().until(ExpectedConditions.elementToBeClickable(element));
    }


    public void click(WebElement element){
        waitForElementToBeClickAble(element);
        element.click();
    }

 }



