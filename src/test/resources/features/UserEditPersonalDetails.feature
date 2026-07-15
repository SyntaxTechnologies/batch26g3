Feature: ESS User edit personal details related user stories

  @edit-personal-details
Scenario: Verify all fields for updating personal contact details are displayed and enabled
  When ESS user enters valid username and password
  And user clicks on login button
  Then user is able to logged in successfully.
  When user clicks the MyInfo option
  And  user clicks the Personal Details option
  Then the following fields are displayed and enabled
    | firstName     |
    | middleName    |
    | lastName      |
    | nationality   |
    | maritalStatus |
    | gender        |