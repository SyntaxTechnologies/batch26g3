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

  @validation
  Scenario Outline: Login with missing required fields
    When user enters "<username>" and "<password>"
    And user clicks on login button
    Then the system shows "Required" for the "<field>" field
    Examples:
      |username |password|field|
      |admin    |        |password|
      |         |admin123|username|
      |         |        |both    |