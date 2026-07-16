package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class EditPersonalDetailsPage extends CommonMethods {

    @FindBy(xpath = "//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement id;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='middleName']")
    public WebElement middleName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//div[contains(@class,'oxd-radio-wrapper')]//label")
    public List<WebElement> genderLabels;

    @FindBy(xpath = "//div[contains(@class,'oxd-radio-wrapper')]//input[@type='radio']")
    public List<WebElement> genderInputs;

    @FindBy(xpath = "//label[text()='Nationality']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]")
    public WebElement nationality;

    @FindBy(xpath = "//label[text()='Marital Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]")
    public WebElement maritalStatus;

    @FindBy(xpath = "//button[text()=' Save ']")
    public WebElement saveButton;

    @FindBy(xpath = "//a/span[text()='My Info']")
    public WebElement myInfoButton;

    @FindBy(xpath = "//a[text()='Personal Details']")
    public WebElement personalDetailsButton;

   public WebElement getGenderElement(String gender)
   {
      return  driver.findElement(By.xpath("//label[text()='"+gender+"']"));
   }

    public WebElement getGenderInputElement(String gender) {
        String value = gender.equalsIgnoreCase("Male") ? "1" : "2";
        return driver.findElement(By.xpath(
                "//div[contains(@class,'oxd-radio-wrapper')]//input[@type='radio' and @value='" + value + "']"
        ));
    }

   public WebElement getMartialStatusElement(String statusToBeSelected)
   {
       click(maritalStatus);
       return driver.findElement(By.xpath("//div[@role='option']/span[text()='"+statusToBeSelected+"']"));
   }

    public WebElement getNationalityElement(String nationalityToBeSelected)
    {
        click(nationality);
        return driver.findElement(By.xpath("//div[@role='option']/span[text()='"+nationalityToBeSelected+"']"));
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

    public EditPersonalDetailsPage() {
        PageFactory.initElements(driver,this);
    }
}
