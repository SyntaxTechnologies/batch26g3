package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;

import java.time.Duration;
import java.util.Map;

public class EditContactDetailsPage extends CommonMethods {
    @FindBy(xpath="//span[contains(normalize-space(),'My Info')]")
    public WebElement infoBtn;

    @FindBy(partialLinkText = "Contact")
    public WebElement contactDetailsBtn;

    @FindBy(xpath = "//label[normalize-space()='Street 1']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement street1Field;

    @FindBy(xpath = "//label[normalize-space()='Street 2']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement street2Field;

    @FindBy(xpath = "//label[normalize-space()='City']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement cityField;

    @FindBy(xpath = "//label[normalize-space()='State/Province']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement stateField;

    @FindBy(xpath = "//label[normalize-space()='Zip/Postal Code']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement zipcodeField;

    @FindBy(xpath = "//label[normalize-space()='Country']" +
            "/ancestor::div[contains(@class,'oxd-input-group')]" +
            "//div[contains(@class,'oxd-select-text')]")
    public WebElement countryDropdown;

    @FindBy(xpath = "//label[normalize-space()='Mobile']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement mobilePhoneField;

    @FindBy(xpath = "//label[normalize-space()='Home']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement homePhoneField;

    @FindBy(xpath = "//label[normalize-space()='Work']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement workPhoneField;

    @FindBy(xpath = "//label[normalize-space()='Work Email']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement workEmailField;

    @FindBy(xpath = "//label[normalize-space()='Other Email']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement otherEmailField;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement saveBtn;

    public void selectCountry(String country) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//label[normalize-space()='Country']" +
                                        "/ancestor::div[contains(@class,'oxd-input-group')]" +
                                        "//div[contains(@class,'oxd-select-text')]"
                        )
                )
        );

        dropdown.click();

        WebElement countryOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//div[@role='option']//span[normalize-space()='"
                                        + country + "']"
                        )
                )
        );

        countryOption.click();
    }

    public void replaceText(String text, WebElement element) {
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }



    public void fillContactDetails(Map<String, String> contactDetails) {

        replaceText(contactDetails.get("Address Street 1"), street1Field);
        replaceText(contactDetails.get("Address Street 2"), street2Field);
        replaceText(contactDetails.get("City"), cityField);
        replaceText(contactDetails.get("State"), stateField);
        replaceText(contactDetails.get("Zip Code"), zipcodeField);
        replaceText(contactDetails.get("Home Phone"), homePhoneField);
        replaceText(contactDetails.get("Mobile Phone"), mobilePhoneField);
        replaceText(contactDetails.get("Work Phone"), workPhoneField);
        replaceText(contactDetails.get("Work Email"), workEmailField);
        replaceText(contactDetails.get("Other Email"), otherEmailField);

        selectCountry(contactDetails.get("Country"));
    }

    public EditContactDetailsPage(){
        PageFactory.initElements(driver,this);
    }




}
