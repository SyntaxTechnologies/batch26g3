package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.Constants;

import java.io.File;

public class profilePicUploadSteps extends CommonMethods {


    @When("the user navigates to the personal profile picture section")
    public void the_user_navigates_to_the_personal_profile_picture_section() {
            // 1. Click 'My Info' to go to the employee profile page
            click(profilePicUploadPage.infoBtn);

            // 2. Click the profile picture avatar/plus icon to open the upload dialogue
            click(profilePicUploadPage.profilePicture);
    }

    @When("the user selects a valid profile picture file to upload")
    public void the_user_selects_a_valid_profile_picture_file_to_upload() {

        String filePath = new File(Constants.PROFILE_PHOTO).getAbsolutePath();

        profilePicUploadPage.profilePictureAddButton.sendKeys(filePath);
    }


    @When("the user clicks the upload save button")
    public void the_user_clicks_the_upload_save_button() {
        // Click the Save button to upload the profile picture
        click(profilePicUploadPage.saveBtn);

    }
    @Then("the user should see their updated profile picture on the page")
    public void the_user_should_see_their_updated_profile_picture_on_the_page() {

        Assert.assertTrue("The updated profile picture is not displayed!",
                profilePicUploadPage.profilePicture.isDisplayed());
    }

    @When("the user selects an invalid file format to upload")
    public void the_user_selects_an_invalid_file_format_to_upload() {

        String invalidFilePath = new File(Constants.INVALID_FILE).getAbsolutePath();

        profilePicUploadPage.profilePictureAddButton.sendKeys(invalidFilePath);
    }

    @Then("the system should display an error message regarding file format")
    public void the_system_should_display_an_error_message_regarding_file_format() {

        Assert.assertTrue(profilePicUploadPage.errorMessage.isDisplayed());


    }




}
