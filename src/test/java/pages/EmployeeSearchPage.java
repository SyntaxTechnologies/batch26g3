package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import static utils.CommonMethods.driver;

public class EmployeeSearchPage extends CommonMethods {
    @FindBy(xpath = "(//*[@class='oxd-input oxd-input--active'])[2]")
    public WebElement empIdSearchField;

    @FindBy(xpath = "(//*[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input)[1]")
    public WebElement empNameSearchField;

    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active']")
    public WebElement employeeIDField;

    @FindBy(xpath = "//label[text()='Employee Name']")
    public WebElement employeeNameField;

    @FindBy(xpath = "//span[text()='No Records Found']")
    public WebElement noRecordsFoundMessage;

    public EmployeeSearchPage() {
        //the code we write will be automatically called when you create an object
        //page factory we use to initialise all the elements we use from selenium and the driver is coming from cm
        PageFactory.initElements(driver, this);
    }
}
