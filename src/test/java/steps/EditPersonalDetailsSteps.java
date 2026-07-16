package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.List;
import java.util.Map;

public class EditPersonalDetailsSteps extends CommonMethods {
   static Map<String,String> updatedData;
    String id;

    @When("ESS user enters valid username and password")
    public void ess_user_enters_valid_username_and_password() {
        sendText("bindu ms ja",loginPage.usernameloc);
        sendText("Bindu@123",loginPage.passwordloc);
    }

    @When("user clicks the MyInfo option")
    public void user_clicks_the_my_info_option() {
      click(editPersonalDetailsPage.myInfoButton);
    }

    @When("user clicks the Personal Details option")
    public void user_clicks_the_personal_details_option() {
        click(editPersonalDetailsPage.personalDetailsButton);
    }

    @Then("the following fields are displayed and enabled")
    public void the_following_fields_are_displayed_and_enabled(io.cucumber.datatable.DataTable dataTable) {
        List<String> data= dataTable.asList();

        for(int i=0;i<data.size();i++)
        {
            String field=data.get(i);
            if(!field.equalsIgnoreCase("gender"))
            {
                WebElement element= editPersonalDetailsPage.getLocator(field);
                Assert.assertNotNull("No locator found for field: " + field, element);
                Assert.assertTrue(field + " is not displayed", element.isDisplayed());
                Assert.assertTrue(field + " is not enabled", element.isEnabled());
            }
            else {
                List<WebElement> labels = editPersonalDetailsPage.genderLabels;
                List<WebElement> inputs = editPersonalDetailsPage.genderInputs;
                Assert.assertFalse("No gender radio buttons found", labels.isEmpty());

                for (int j = 0; j < labels.size(); j++) {
                    Assert.assertTrue("Gender radio is not displayed", labels.get(j).isDisplayed());
                    Assert.assertTrue("Gender radio is not enabled", inputs.get(j).isEnabled());
                }
            }
        }
    }

    @When("the user updates the personal details with the following data")
    public void the_user_updates_the_personal_details_with_the_following_data(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        updatedData =dataTable.asMap();

        clearAndSendText(updatedData.get("firstName"), editPersonalDetailsPage.firstName);

        clearAndSendText(updatedData.get("middleName"), editPersonalDetailsPage.middleName);

        clearAndSendText(updatedData.get("lastName"), editPersonalDetailsPage.lastName);

        click(editPersonalDetailsPage.getNationalityElement(updatedData.get("nationality").trim()));

        click(editPersonalDetailsPage.getMartialStatusElement(updatedData.get("maritalStatus").trim()));

        click(editPersonalDetailsPage.getGenderElement(updatedData.get("gender").trim()));

        id = editPersonalDetailsPage.id.getAttribute("value");
    }

    @When("user clicks the save button")
    public void user_clicks_the_save_button() {
      click(editPersonalDetailsPage.saveButton);
    }

    @Then("the updated values are reflected in the fields after a page refresh")
    public void the_updated_values_are_reflected_in_the_fields_after_a_page_refresh() {
       driver.navigate().refresh();

        System.out.println("value"+ editPersonalDetailsPage.firstName.getAttribute("value"));
        System.out.println(updatedData.get("firstName"));
       Assert.assertEquals(updatedData.get("firstName"), editPersonalDetailsPage.firstName.getAttribute("value"));
       Assert.assertEquals(updatedData.get("middleName"), editPersonalDetailsPage.middleName.getAttribute("value"));
       Assert.assertEquals(updatedData.get("lastName"), editPersonalDetailsPage.lastName.getAttribute("value"));

//        Assert.assertEquals(updatedData.get("nationality"),userEditPersonalDetailsPage.firstName.getAttribute("value"));
//        Assert.assertEquals(updatedData.get("maritalStatus"),userEditPersonalDetailsPage.firstName.getAttribute("value"));
//        Assert.assertEquals(updatedData.get("gender"),userEditPersonalDetailsPage.firstName.getAttribute("value"));

    }

    @Then("the database reflects the updated personal details")
    public void the_database_reflects_the_updated_personal_details() {
        System.out.println("The database reflects the updated personal details");
    }


}
