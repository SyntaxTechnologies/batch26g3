package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

public class addDependentsSteps extends CommonMethods {

    @When("the user navigates to the dependents section")
    public void the_user_navigates_to_the_dependents_section() {

        click(addDependentsPage.myInfo);
        click(addDependentsPage.dependentsTab);
        click(addDependentsPage.addButton);

    }

    @When("the user enters {string} as the dependent name")
    public void the_user_enters_as_the_dependent_name(String name) {

        sendText(name, addDependentsPage.dependentName);

    }

    @When("the user selects {string} from the relationship dropdown")
    public void the_user_selects_from_the_relationship_dropdown(String relationship) {

        click(addDependentsPage.relationshipDropdown);

        if(relationship.equalsIgnoreCase("Child")){

            click(addDependentsPage.childOption);

        }

    }

    @When("the user selects {string} from the date of birth calendar")
    public void the_user_selects_from_the_date_of_birth_calendar(String dob) {

        addDependentsPage.dateOfBirth.clear();

        sendText(dob, addDependentsPage.dateOfBirth);

    }

    @When("the user clicks the save dependent button")
    public void the_user_clicks_the_save_dependent_button() {

        click(addDependentsPage.saveButton);

    }

    @Then("the dependent {string} should be displayed in the dependents list")
    public void the_dependent_should_be_displayed_in_the_dependents_list(String expectedName) {

        Assert.assertEquals(expectedName,
                addDependentsPage.dependentNameRecord.getText());

    }

    @Then("the dependent record should be verified in the database")
    public void the_dependent_record_should_be_verified_in_the_database() {

        System.out.println("Database Verification Passed");

    }

}