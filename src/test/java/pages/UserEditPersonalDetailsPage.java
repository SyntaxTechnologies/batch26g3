package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class UserEditPersonalDetailsPage extends CommonMethods {

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='middleName']")
    public WebElement middleName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@type='radio']")
    public List<WebElement> genders;

    @FindBy(xpath = "//label[text()='Nationality']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]")
    public WebElement nationality;

    @FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
    public List<WebElement> nationalityOptions;

    @FindBy(xpath = "//label[text()='Marital Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]")
    public WebElement maritalStatus;

    @FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
    public List<WebElement> maritalStatusOptions;

    @FindBy(xpath = "//button[text()=' Save ']")
    public List<WebElement> saveButton;

    @FindBy(xpath = "//a/span[text()='My Info']")
    public WebElement myInfoButton;

    @FindBy(xpath = "//a[text()='Personal Details']")
    public WebElement personalDetailsButton;

    public void getByValue(String valueToBeSelected)
    {

    }

    public WebElement getLocator(String fieldName)
    {
        switch(fieldName)
        {
            case "firstName": return firstName;
            case "middleName": return middleName;
            case "lastName": return lastName;
            case "nationality": return nationality;
            case "maritalStatus": return maritalStatus;
        }

        return null;
    }

    public  UserEditPersonalDetailsPage() {
        PageFactory.initElements(driver,this);
    }
}
