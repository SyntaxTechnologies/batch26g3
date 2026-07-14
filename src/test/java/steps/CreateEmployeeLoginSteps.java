package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class CreateEmployeeLoginSteps extends CommonMethods {

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

    @When("the admin enters the userRole as {string}, employee name as {string}, status as {string}, username,password and confirm password")
    public void the_admin_enters_the_user_role_as_employee_name_as_status_as_username_password_and_confirm_password(String userRole,String employeeName, String status) throws InterruptedException {
        click(createEmployeeLoginPage.userRole);
        click(createEmployeeLoginPage.essUserOption);

        sendText(employeeName, createEmployeeLoginPage.employeeName);
        click(createEmployeeLoginPage.employeeNameOption,true);

        click(createEmployeeLoginPage.status);
        click(createEmployeeLoginPage.enabledStatusOption);

        sendText(employeeName+"User" + generateRandomNumber(), createEmployeeLoginPage.userName);

        sendText("Testpass@123", createEmployeeLoginPage.password);
        sendText("Testpass@123", createEmployeeLoginPage.confirmPassword);

        Thread.sleep(3000);

    }
    @When("user clicks save button")
    public void user_clicks_save_button() {
        click(createEmployeeLoginPage.saveButton);
    }

    @Then("the user login details are created successfully")
    public void the_user_login_details_are_created_successfully() {
        String viewSystemUsersUrl = ConfigReader.read("viewSystemUsersUrl");
        waitForUrl(viewSystemUsersUrl);
        System.out.println(viewSystemUsersUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(viewSystemUsersUrl));
    }
}
