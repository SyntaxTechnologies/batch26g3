package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.List;

public class UserEditPersonalDetailsSteps extends CommonMethods {

    @When("ESS user enters valid username and password")
    public void ess_user_enters_valid_username_and_password() {
        sendText("bindu ms ja",loginPage.usernameloc);
        sendText("Bindu@123",loginPage.passwordloc);
    }

    @When("user clicks the MyInfo option")
    public void user_clicks_the_my_info_option() {
      click(userEditPersonalDetailsPage.myInfoButton);
    }

    @When("user clicks the Personal Details option")
    public void user_clicks_the_personal_details_option() {
        click(userEditPersonalDetailsPage.personalDetailsButton);
    }

    @Then("the following fields are displayed and enabled")
    public void the_following_fields_are_displayed_and_enabled(io.cucumber.datatable.DataTable dataTable) {
        List<String> list = dataTable.asList();

        for(int i=0;i<list.size();i++)
        {
            String field=list.get(i);
            if(!field.equalsIgnoreCase("gender"))
            {
                WebElement element=userEditPersonalDetailsPage.getLocator(field);
                Assert.assertNotNull("No locator found for field: " + field, element);
                Assert.assertTrue(field + " is not displayed", element.isDisplayed());
                Assert.assertTrue(field + " is not enabled", element.isEnabled());
            }
            else {
                List<WebElement> elements = userEditPersonalDetailsPage.genders;
                Assert.assertFalse("No gender radio buttons found", elements.isEmpty());
                for(WebElement element : elements)
                {
                    waitForElementToBeVisible(element);
                 //   Assert.assertTrue("Gender radio is not displayed", element.isDisplayed());
                   Assert.assertTrue("Gender radio is not enabled", element.isEnabled());

                }
            }
        }
    }


}
