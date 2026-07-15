package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
    @FindBy(xpath = "//span[text()='PIM']")
    public WebElement pimButton;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='middleName']")
    public WebElement middleName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "(//div[@class='oxd-grid-item oxd-grid-item--gutters'])[2]//input")
    public WebElement id;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[text()='Required']")
    public WebElement errorMsg;

    @FindBy(xpath = ("//h6[normalize-space()='Personal Details']"))
    public WebElement savedTitle;







    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }
}
