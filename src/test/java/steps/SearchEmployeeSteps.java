package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchEmployeeSteps extends CommonMethods{


    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimOption = driver.findElement(By.xpath("(//*[text()='PIM'])[1]"));
        click(pimOption);

    }

    @When("user enters valid employee full name \"Dayae Lazrak\"")
    public void user_enters_valid_employee_first_name_and_last_name()  {
        sendText("Dayae Lazrak", employeeSearchPage.empNameSearchField);

    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        click(employeeSearchPage.searchButton);

    }
    @Then("user is able to see list of matched employees details")
    public void user_is_able_to_see_list_of_matched_employees_details() {
        System.out.println("Employee can be seen");
        }

    @When("user enters a partial full name name \"Dave\"")
    public void user_enters_a_partial_full_name_name() {
        sendText("Dave", employeeSearchPage.empNameSearchField);
    }

    @When("user enters a mixed capitalization of valid employee full name {string}")
    public void user_enters_a_mixed_capitalization_of_valid_employee_full_name(String string) {
        sendText("daVe", employeeSearchPage.empNameSearchField);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        sendText("0914", employeeSearchPage.empIdSearchField);
    }
    @Then("user is able to see the employee details")
    public void user_is_able_to_see_the_employee_details() {
        System.out.println("Employee can be seen");
        }

        @When("user enters a not valid employee id")
        public void user_enters_a_not_valid_employee_id() {
            sendText("786555", employeeSearchPage.empIdSearchField);
        }
        @Then("user is able to see a message {string}")
        public void user_is_able_to_see_a_message_no_records_found(String message) {
        assertTrue(employeeSearchPage.noRecordsFoundMessage.isDisplayed());
        Assert.assertEquals(message,employeeSearchPage.noRecordsFoundMessage.getText().trim());
        System.out.println(employeeSearchPage.noRecordsFoundMessage);
        }

}








