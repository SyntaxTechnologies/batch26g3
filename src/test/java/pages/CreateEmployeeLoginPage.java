package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class CreateEmployeeLoginPage extends CommonMethods {

    @FindBy(xpath = "//a/span[text()='Admin']")
    public WebElement adminButton;

    @FindBy(xpath = "//li/span[text()='User Management ']")
    public WebElement userManagementButton;

    @FindBy(xpath = "//button[text()=' Add ']")
    public WebElement addButton;

    @FindBy(xpath = "//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]")
     public WebElement userRole;

    @FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
    public List<WebElement> userRoleOptions;

    @FindBy(xpath = "//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-field-error-message')]")
    public WebElement userRoleErrorLoc;

    @FindBy(xpath = "//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement employeeName;

    @FindBy(xpath = "(//div[contains(@class,'oxd-autocomplete-dropdown')]//div[@role='option'])[1]")
    public WebElement employeeNameOption;

    @FindBy(xpath = "//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-field-error-message')]")
    public WebElement employeeNameErrorLoc;

    @FindBy(xpath = "//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]")
    public WebElement status;

    @FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
    public List<WebElement> enabledStatusOptions;

    @FindBy(xpath = "//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-field-error-message')]")
    public WebElement statusErrorLoc;

    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    public WebElement userName;

    @FindBy(xpath = "//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-field-error-message')]")
    public WebElement userNameErrorLoc;

    @FindBy(xpath = "//label[text()='Password']/following::input[1]")
    public WebElement password;

    @FindBy(xpath = "//label[text()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-field-error-message')]")
    public WebElement passwordErrorLoc;

    @FindBy(xpath = "//label[text()='Password']/ancestor::div[contains(@class,'user-password-cell')]/span[contains(@class,'oxd-chip')]")
    public WebElement passwordStrengthErrorLoc;

    @FindBy(xpath = "//label[text()='Confirm Password']/following::input[1]")
    public WebElement confirmPassword;

    @FindBy(xpath = "//label[text()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-field-error-message')]")
    public WebElement confirmPasswordErrorLoc;

    @FindBy(xpath = "//button[text()=' Save ']")
    public WebElement saveButton;

    @FindBy(xpath = "//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement visitUsername;

    @FindBy(xpath = "//button[text()=' Search ']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,'oxd-table-body')]//div[contains(@class,'oxd-padding-cell')][2]")
    public WebElement foundUserName;

    @FindBy(xpath = "//div[contains(@class,'oxd-table-body')]//div[contains(@class,'oxd-padding-cell')][4]")
    public WebElement foundEmployeeName;

     public CreateEmployeeLoginPage() {
        PageFactory.initElements(driver,this);
    }
}
