package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.DBReader;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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
                WebElement element= editPersonalDetailsPage.getElementByFieldName(field);
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

        click(editPersonalDetailsPage.openDropdownAndGetOption(editPersonalDetailsPage.nationality,updatedData.get("nationality").trim()));

        click(editPersonalDetailsPage.openDropdownAndGetOption(editPersonalDetailsPage.maritalStatus, updatedData.get("maritalStatus").trim()));

        click(editPersonalDetailsPage.getGenderLabelElement(updatedData.get("gender").trim()));

        id = editPersonalDetailsPage.id.getAttribute("value");
    }

    @When("user clicks the save button")
    public void user_clicks_the_save_button() {
      click(editPersonalDetailsPage.saveButton);
    }

    @Then("the updated values are reflected in the fields after a page refresh")
    public void the_updated_values_are_reflected_in_the_fields_after_a_page_refresh() {
       driver.navigate().refresh();

        waitForValueToBePopulated( editPersonalDetailsPage.firstName);
        Assert.assertEquals(updatedData.get("firstName"), editPersonalDetailsPage.firstName.getAttribute("value"));

        String expectedMiddleName = updatedData.get("middleName");
        if(expectedMiddleName != null && !expectedMiddleName.isBlank()) {
            waitForValueToBePopulated(editPersonalDetailsPage.middleName);
        }

        String actualMiddleName = editPersonalDetailsPage.middleName.getAttribute("value");
        Assert.assertEquals(updatedData.get("middleName"), Objects.equals(actualMiddleName, "") ?null:actualMiddleName);
      
        waitForValueToBePopulated( editPersonalDetailsPage.lastName);
        Assert.assertEquals(updatedData.get("lastName"), editPersonalDetailsPage.lastName.getAttribute("value"));

        Assert.assertEquals(updatedData.get("nationality"),editPersonalDetailsPage.nationality.getText());

        Assert.assertEquals(updatedData.get("maritalStatus"),editPersonalDetailsPage.maritalStatus.getText());

        Assert.assertTrue(editPersonalDetailsPage.getGenderInputElement(updatedData.get("gender")).isSelected());
    }

    @Then("verify the changes are updated in database")
    public void verify_the_changes_are_updated_in_database() {
        try {
            String query = "select employee_id,emp_firstname,emp_lastname,emp_middle_name,emp_marital_status,emp_gender \n" +
                    "from hs_hr_employee where employee_id="+id+";";

        List<Map<String,String>> dataFromDb= DBReader.fetch(query);
        var actualFirstName =  dataFromDb.get(0).get("emp_firstname");
        var actualMiddleName =  dataFromDb.get(0).get("emp_middle_name");
        var actualLastName =  dataFromDb.get(0).get("emp_lastname");
        var actualMaritalStatus =  dataFromDb.get(0).get("emp_marital_status");
        var actualGender =  dataFromDb.get(0).get("emp_gender");

        Assert.assertEquals(updatedData.get("firstName"),actualFirstName);
        Assert.assertEquals(updatedData.get("middleName"),actualMiddleName);
        Assert.assertEquals(updatedData.get("lastName"),actualLastName);
        Assert.assertEquals(updatedData.get("maritalStatus"),actualMaritalStatus);
        Assert.assertEquals(updatedData.get("gender").equalsIgnoreCase("Male") ? "1" : "2",actualGender);
        }
        catch (Exception e) {
        e.printStackTrace();
        }
    }
}
