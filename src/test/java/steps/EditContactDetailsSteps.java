package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Map;

public class EditContactDetailsSteps extends CommonMethods {
    public static String otherEmailTxt;
    @Given("the employee is logged into the HRMS application")
    public void the_employee_is_logged_into_the_hrms_application() {
        driver.get(ConfigReader.read("url"));
        sendText(ConfigReader.read("userName"), loginPage.usernameloc);
        sendText(ConfigReader.read("password"), loginPage.passwordloc);
        click(loginPage.loginBtn);
    }
    @Given("the employee navigates to the My Info page")
    public void the_employee_navigates_to_the_my_info_page() {
        editContactDetailsPage.infoBtn.click();
    }
    @Given("the employee opens the Contact Details section")
    public void the_employee_opens_the_contact_details_section() {
       editContactDetailsPage.contactDetailsBtn.click();
    }
    @Then("the Address Street {int} field should be displayed")
    public void the_address_street_field_should_be_displayed(Integer int1) {
        Assert.assertTrue(editContactDetailsPage.street1Field.isDisplayed());
        Assert.assertTrue(editContactDetailsPage.street2Field.isDisplayed());
    }
    @Then("the City field should be displayed")
    public void the_city_field_should_be_displayed() {
       Assert.assertTrue(editContactDetailsPage.cityField.isDisplayed());
    }
    @Then("the State field should be displayed")
    public void the_state_field_should_be_displayed() {
        Assert.assertTrue(editContactDetailsPage.stateField.isDisplayed());

    }
    @Then("the Zip Code field should be displayed")
    public void the_zip_code_field_should_be_displayed() {
       Assert.assertTrue(editContactDetailsPage.zipcodeField.isDisplayed());

    }
   @Then("the Country dropdown should be displayed")
    public void the_country_dropdown_should_be_displayed() {
        Assert.assertTrue(editContactDetailsPage.countryDropdown.isDisplayed());
    }
    @Then("the Home Phone field should be displayed")
    public void the_home_phone_field_should_be_displayed() {
        Assert.assertTrue(editContactDetailsPage.homePhoneField.isDisplayed());
    }
    @Then("the Mobile Phone field should be displayed")
    public void the_mobile_phone_field_should_be_displayed() {
        Assert.assertTrue(editContactDetailsPage.mobilePhoneField.isDisplayed());
    }
    @Then("the Work Phone field should be displayed")
    public void the_work_phone_field_should_be_displayed() {
        Assert.assertTrue(editContactDetailsPage.workPhoneField.isDisplayed());
    }
    @Then("the Work Email field should be displayed")
    public void the_work_email_field_should_be_displayed() {
        Assert.assertTrue(editContactDetailsPage.workEmailField.isDisplayed());
    }
    @Then("the Other Email field should be displayed")
    public void the_other_email_field_should_be_displayed() {
        Assert.assertTrue(editContactDetailsPage.otherEmailField.isDisplayed());
    }
    @Then("the Save button should be displayed")
    public void the_save_button_should_be_displayed() {
        Assert.assertTrue(editContactDetailsPage.saveBtn.isDisplayed());
    }
    @When("the employee updates the contact details with:")
    public void the_employee_updates_the_contact_details_with(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> contactDetails=dataTable.asMap();
        editContactDetailsPage.fillContactDetails(contactDetails);

    }
    @When("the employee clicks the Save button")
    public void the_employee_clicks_the_save_button() {
        otherEmailTxt=editContactDetailsPage.otherEmailField.getAttribute("value");
        System.out.println(otherEmailTxt);
        editContactDetailsPage.saveBtn.click();
    }
    @When("the employee refreshes the page")
    public void the_employee_refreshes_the_page() {
        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(
                editContactDetailsPage.otherEmailField
        ));
    }
    @Then("the previously saved contact details should still be displayed")
    public void the_previously_saved_contact_details_should_still_be_displayed() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.attributeToBe(
                editContactDetailsPage.otherEmailField,
                "value",
                otherEmailTxt
        ));

        String actualEmail =
                editContactDetailsPage.otherEmailField.getDomProperty("value");

        Assert.assertEquals(otherEmailTxt, actualEmail);
    }


}
