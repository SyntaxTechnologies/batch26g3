package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;


public class CreateEmployeeLoginSteps extends CommonMethods {
  static String createdUserName;

    @When("admin clicks the Admin option")
    public void admin_clicks_the_admin_option() {
      click(createEmployeeLoginPage.adminButton);
    }

    @When("admin clicks the User management option")
    public void admin_clicks_the_user_management_option() {
        click(createEmployeeLoginPage.userManagementButton);
    }

    @When("admin clicks the Add button")
    public void admin_clicks_the_add_button() {
        click(createEmployeeLoginPage.addButton);
    }

    @When("the admin enters the userRole as {string}, employee name as {string}, status as {string}, username as {string},password as {string} and confirm password as {string}")
    public void the_admin_enters_the_user_role_as_employee_name_as_status_as_username_as_password_as_and_confirm_password_as(String userRole,String employeeName, String status, String userName, String password, String confirmPassword) throws InterruptedException {
        click(createEmployeeLoginPage.userRole);
        selectOptionByText(createEmployeeLoginPage.userRoleOptions,userRole);

        if(!employeeName.isBlank()){
            sendText(employeeName, createEmployeeLoginPage.employeeName);
            click(createEmployeeLoginPage.employeeNameOption,true);
        }

        click(createEmployeeLoginPage.status);
        selectOptionByText(createEmployeeLoginPage.enabledStatusOptions,status);

        createdUserName= userName + generateRandomNumber();

        if(!userName.isBlank()) {
            sendText(createdUserName, createEmployeeLoginPage.userName);
        }

        sendText(password, createEmployeeLoginPage.password);
        sendText(confirmPassword, createEmployeeLoginPage.confirmPassword);
    }

    @When("user clicks save button")
    public void user_clicks_save_button() {
        click(createEmployeeLoginPage.saveButton);
    }

    @Then("the user login details are created successfully")
    public void the_user_login_details_are_created_successfully() {
        String viewSystemUsersUrl = ConfigReader.read("viewSystemUsersUrl");
        waitForUrl(viewSystemUsersUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(viewSystemUsersUrl));
    }

    @Then("the error message {string} is shown beside {string} field")
    public void the_error_message_is_shown_beside_field(String message, String fieldName) {
        WebElement element = null;

        switch(fieldName) {
            case "user role":element=createEmployeeLoginPage.userRoleErrorLoc;break;
            case "status":element=createEmployeeLoginPage.statusErrorLoc;break;
            case "employee name":element=createEmployeeLoginPage.employeeNameErrorLoc;break;
            case "user name":element=createEmployeeLoginPage.userNameErrorLoc;break;
            case "password":element=createEmployeeLoginPage.passwordErrorLoc;break;
            case "password strength":element=createEmployeeLoginPage.passwordStrengthErrorLoc;break;
            case "confirm password":element=createEmployeeLoginPage.confirmPasswordErrorLoc;break;
        }

        Assert.assertTrue(element.isDisplayed());

        if(fieldName.equals("password strength")){
            waitForTextToBeExpectedTest(element,message);
        }

        Assert.assertEquals(message,element.getText());
    }

    @When("the user enters the  password as {string} and confirm password as {string}")
    public void the_user_enters_the_password_as_and_confirm_password_as(String password, String confirmPassword) {
        sendText(password, createEmployeeLoginPage.password);
        sendText(confirmPassword, createEmployeeLoginPage.confirmPassword);
    }

    @When("the user enters the  password as {string}")
    public void the_user_enters_the_password_as(String password) {
        sendText(password, createEmployeeLoginPage.password);
    }

    @Then("the created user is linked to employee {string}")
    public void the_created_user_is_linked_to_employee(String employeeName) throws InterruptedException {
        sendText(createdUserName, createEmployeeLoginPage.visitUsername);
        click(createEmployeeLoginPage.searchButton);

        waitForElementToBeVisible(createEmployeeLoginPage.foundUserName);
        waitForElementToBeVisible(createEmployeeLoginPage.foundEmployeeName);

        Assert.assertEquals(createdUserName, createEmployeeLoginPage.foundUserName.getText());
        Assert.assertEquals(employeeName, createEmployeeLoginPage.foundEmployeeName.getText());
    }

}
