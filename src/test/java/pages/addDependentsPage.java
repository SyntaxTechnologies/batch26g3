package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class addDependentsPage extends CommonMethods {

    public addDependentsPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[contains(@href, 'viewMyDetails')]")
    public WebElement myInfo;
    // Dependents Tab
    @FindBy(xpath = "//a[text()='Dependents']")
    public WebElement dependentsTab;

    // Add button
    @FindBy(xpath = "//button[contains(.,'Add')]")
    public WebElement addButton;

    // Name
    @FindBy(xpath="//label[text()='Name']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement dependentName;

    // Relationship dropdown
    @FindBy(xpath="//label[text()='Relationship']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")
    public WebElement relationshipDropdown;

    // Child option
    @FindBy(xpath="//div[@role='option']//span[text()='Child']")
    public WebElement childOption;

    // DOB
    @FindBy(xpath="//label[text()='Date of Birth']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement dateOfBirth;

    // Save
    @FindBy(xpath="//button[@type='submit']")
    public WebElement saveButton;

    // Success Message
    @FindBy(xpath="//div[contains(@class,'oxd-toast-content')]")
    public WebElement successMessage;

    // Dependent record
    @FindBy(xpath="//div[@class='oxd-table-body']//div[@role='row']")
    public WebElement dependentTable;

    @FindBy(xpath="//div[@class='oxd-table-body']//div[@role='cell'][2]")
    public WebElement dependentNameRecord;

}