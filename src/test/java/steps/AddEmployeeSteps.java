package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class AddEmployeeSteps extends CommonMethods {
    @When("user login to HRms application")
    public void userLoginToHRmsApplication() {
        driver.get(ConfigReader.read("url"));
        sendText(ConfigReader.read("userName"), loginPage.usernameloc);
        sendText(ConfigReader.read("password"), loginPage.passwordloc);
        click(loginPage.loginBtn);

    }

    @And("user navigate to PIM page")
    public void userNavigateToPIMPage() {
        click(addEmployeePage.pimButton);
    }

    @And("user clicks on Add button")
    public void userClicksOnAddButton() {
        click(addEmployeePage.addButton);
    }

    @And("user fill the fields except employee id")
    public void userFillTheFieldsExceptEmployeeId() {
        sendText("John", addEmployeePage.firstName);
        sendText("Doe", addEmployeePage.lastName);
        addEmployeePage.id.clear();

    }

    @And("user clicks on save button")
    public void userClicksOnSaveButton() {
        click(addEmployeePage.saveButton);
    }

    @Then("system should generate employee id")
    public void systemShouldGenerateEmployeeId() {
        Assert.assertTrue(addEmployeePage.id.getText().isBlank());
    }

    @And("user fill the fields")
    public void userFillTheFields() {
        sendText("John", addEmployeePage.firstName);
        sendText("Doe", addEmployeePage.lastName);
        sendText("31909", addEmployeePage.id);
        click(addEmployeePage.saveButton);
    }

    @Then("employee is saved successfully")
    public void employeeIsSavedSuccessfully() {
        Assert.assertTrue(addEmployeePage.savedTitle.isDisplayed());
    }

    @And("a required field is empty")
    public void aRequiredFieldIsEmpty() {
        addEmployeePage.lastName.clear();
    }

    @And("user clicks on save")
    public void userClicksOnSave() {
        click(addEmployeePage.saveButton);
    }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        Assert.assertTrue(addEmployeePage.errorMsg.isDisplayed());
    }
}
