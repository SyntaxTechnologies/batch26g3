package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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
        //Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        Assert.assertTrue(loginPage.dashboardText.isDisplayed());
    }

}
