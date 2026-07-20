package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class profilePicUploadPage extends CommonMethods {

    public profilePicUploadPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[contains(@href, 'viewMyDetails')]")
    public WebElement infoBtn;

    @FindBy(xpath="(//img[@alt='profile picture'])[2]")
    public WebElement profilePicture;

    @FindBy(xpath="//input[@type='file']")
    public WebElement profilePictureAddButton;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement fileInput;

     @FindBy(xpath = "//i[@data-v-bddebfba and contains(@class, 'bi-plus')]")
    public WebElement profilePicture2;

     @FindBy(xpath = "//button[normalize-space()='Save']")
      public WebElement saveBtn;

    // Error message container that displays when format validation fails
    @FindBy(xpath = "//span[contains(@class, 'oxd-input-field-error-message')]")
    public WebElement errorMessage;
}

     //notes: The normalize-space() function performs two specific cleaning tasks on a string:
     //Trims: It removes all leading (at the start) and trailing (at the end) whitespace.
     //Compresses: It replaces sequences of multiple spaces, tabs, or newlines in the middle of the text with a single space.

