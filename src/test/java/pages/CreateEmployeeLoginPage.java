package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class CreateEmployeeLoginPage extends CommonMethods {

    @FindBy(xpath = "//a/span[text()='Admin']")
    public WebElement adminButton;

    @FindBy(xpath = "//li/span[text()='User Management ']")
    public WebElement userManagementButton;

    @FindBy(xpath = "//button[text()=' Add ']")
    public WebElement addButton;

    @FindBy(xpath = "//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]")
     public WebElement userRole;

    @FindBy(xpath = "//div[@role='listbox']//div[@role='option']/span[text()='ESS']")
    public WebElement essUserOption;

    @FindBy(xpath = "//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    public WebElement employeeName;

    @FindBy(xpath = "(//div[contains(@class,'oxd-autocomplete-dropdown')]//div[@role='option'])[1]")
    public WebElement employeeNameOption;

    @FindBy(xpath = "//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]")
    public WebElement status;

    @FindBy(xpath = "//div[@role='listbox']//div[@role='option']/span[text()='Enabled']")
    public WebElement enabledStatusOption;

    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    public WebElement userName;

    @FindBy(xpath = "//label[text()='Password']/following::input[1]")
    public WebElement password;

    @FindBy(xpath = "//label[text()='Confirm Password']/following::input[1]")
    public WebElement confirmPassword;

    @FindBy(xpath = "//button[text()=' Save ']")
    public WebElement saveButton;

    @FindBy(xpath = "//label[text()='Username']//following::input[1]")
    public WebElement visitUsersUserName;

    @FindBy(xpath = "//button[text()=' Search ']")
    public WebElement searchButton;

    public CreateEmployeeLoginPage() {
        PageFactory.initElements(driver,this);
    }
}
