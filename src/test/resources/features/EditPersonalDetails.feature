Feature: ESS User edit personal details related user stories

  Background:
    When ESS user enters valid username and password
    And user clicks on login button
    Then user is able to logged in successfully.
    When user clicks the MyInfo option
    And  user clicks the Personal Details option

@edit-personal-details
Scenario: Verify all fields for updating personal contact details are displayed and enabled
  Then the following fields are displayed and enabled
    | firstName     |
    | middleName    |
    | lastName      |
    | nationality   |
    | maritalStatus |
    | gender        |

  @edit-personal-details
   Scenario: Updating the personal information is successful
    When the user updates the personal details with the following data
      | firstName     |BinduJ   |
      | middleName    |msJ      |
      | lastName      |JanaJ    |
      | nationality   |Greek    |
      | maritalStatus |Other    |
      | gender        |Female   |
    And user clicks the save button
    Then the updated values are reflected in the fields after a page refresh
    And verify the changes are updated in database

  @edit-personal-details @optional_field
  Scenario: Updating personal information succeeds without middle name
    When the user updates the personal details with the following data
      | firstName     | Bin    |
      | middleName    |        |
      | lastName      | JA     |
      | nationality   | Indian |
      | maritalStatus | Single |
      | gender        | Male   |
    And user clicks the save button
    Then the updated values are reflected in the fields after a page refresh
