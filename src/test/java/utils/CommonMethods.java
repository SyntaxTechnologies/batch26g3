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
import java.util.List;
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
        driver.get(ConfigReader.read("url"));

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

    public void click(WebElement element, boolean clickableAndOptionReady){
        if(clickableAndOptionReady){
            waitForOptionReadyAndClickable(element);
        }
        else {
            waitForElementToBeClickAble(element);
        }

        element.click();
    }

    public WebElement waitForOptionReadyAndClickable(WebElement element) {
        getwait().until(driver -> {
            try {
                String text = element.getText().trim();
                boolean hasRealText = !text.isEmpty() && !text.toLowerCase().contains("searching");
                boolean isClickable = element.isDisplayed() && element.isEnabled();
                return hasRealText && isClickable;
            } catch (Exception e) {
                return false;
            }
        });
        return element;
    }

    public void waitForTextToBeExpectedTest(WebElement element,String expectedText){
        getwait().until(driver -> element.getText().trim().equalsIgnoreCase(expectedText));
    }

    public void waitForUrl(String url){
        getwait().until(ExpectedConditions.urlContains(url));
    }

    // Generates random number between 1 and 100
    public int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    public void selectDropdownOptionByText(List<WebElement> options, String optionToSelect)
    {
        List<WebElement> elements = options;
        for(var element : elements){
            if(element.getText().equals(optionToSelect)){
                click(element);
                break;
            }
        }
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



