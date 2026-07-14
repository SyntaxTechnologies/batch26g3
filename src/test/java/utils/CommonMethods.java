package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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


    public byte[] takeScreenshot(String fileName){

        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile,
                    new File(Constants.SCREENSHOT_FILEPATH +
                            fileName+" "+
                            getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picByte;
    }


    public String getTimeStamp(String pattern){

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


}



