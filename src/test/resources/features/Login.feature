Feature: Login Related Functionality
  Background:
    Given user is able to launch HRMS application

  @valid
  Scenario: Valid username and password
    When user enters valid username and password
    And user clicks on login button
    Then user is able to logged in successfully.

  @error
  Scenario:Valid username and Invalid password
    When user enters valid username and Invalid password
    And user clicks on login button
    Then the system shows "Invalid credentials"
    And the user remains on the login page
    When the user enters the correct password
    And user clicks on login button
    Then user is able to logged in successfully.

   @emptyP
   Scenario: Valid username and empty password
     When user enters valid username and empty password
     And user clicks on login button
     Then the system shows "Required" for the password field

   @emptyU
   Scenario: Empty username and valid password
     When user leave username empty and valid password
     And user clicks on login button
     Then the system shows "Required" for the username field

   @empty
   Scenario: Empty username and empty password
     When user leave username and password empty
     And user clicks on login button
     Then The system shows "Required" in both username and password field