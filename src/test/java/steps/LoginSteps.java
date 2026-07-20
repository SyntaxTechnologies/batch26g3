package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    @Given("user is able to launch HRMS application")
    public void user_is_able_to_launch_hrms_application() {
        driver.get(ConfigReader.read("url"));
    }


    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameloc);
        sendText(ConfigReader.read("password"), loginPage.passwordloc);
    }


    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginBtn);
    }


    @Then("user is able to logged in successfully.")
    public void user_is_able_to_logged_in_successfully() {
       Assert.assertTrue(loginPage.dashboardText.isDisplayed());
    }

    @When("user enters valid username and Invalid password")
    public void user_enters_valid_username_and_invalid_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameloc);
        sendText("Hrm123", loginPage.passwordloc);

    }

    @Then("the system shows {string}")
    public void the_system_shows(String errorExpected) {

        String actual = loginPage.errorPasswordText.getText();
        Assert.assertEquals(errorExpected, actual);
    }

    @Then("the user remains on the login page")
    public void the_user_remains_on_the_login_page() {
        Assert.assertTrue(loginPage.loginBtn.isDisplayed());
    }


    @When("the user enters the correct password")
    public void the_user_enters_the_correct_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameloc);
        sendText(ConfigReader.read("password"), loginPage.passwordloc);
    }
    @When("user leave username empty and valid password")
    public void user_leave_username_empty_and_valid_password() {
        sendText(ConfigReader.read("password"), loginPage.passwordloc);
    }


    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        sendText(username, loginPage.usernameloc);
        sendText(password, loginPage.passwordloc);

    }
    @Then("the system shows {string} for the {string} field")
    public void the_system_shows_for_the_field(String expectedText, String field) {

        WebElement element;
        switch (field) {
            case "username":
                element = loginPage.usernameRequiredText;
                break;

            case "password":
                element = loginPage.passwordRequiredText;
                break;

            case "both":
                Assert.assertEquals(expectedText, loginPage.usernameRequiredText.getText());
                Assert.assertEquals(expectedText, loginPage.passwordRequiredText.getText());

            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }

        Assert.assertEquals(expectedText, element.getText());

    }





}