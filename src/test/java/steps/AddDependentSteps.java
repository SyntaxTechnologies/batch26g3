package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.ConfigReader;


public class AddDependentSteps extends CommonMethods {
    @Given("user is logged in.")
    public void user_is_logged_in() {
        driver.get(ConfigReader.read("url"));
        sendText(ConfigReader.read("userName"), loginPage.usernameloc);
        sendText(ConfigReader.read("password"), loginPage.passwordloc);
        click(loginPage.loginBtn);

    }
    @Given("navigate to My info page dependents section")
    public void navigate_to_my_info_page_dependents_section() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks on the add button")
    public void user_clicks_on_the_add_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("name, relationship and date of birth fields appear")
    public void name_relationship_and_date_of_birth_fields_appear() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
