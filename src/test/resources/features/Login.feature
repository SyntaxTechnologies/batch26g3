Feature: Login Related Functionality
  Background:
    Given user is able to launch HRMS application

  @valid
  Scenario: Valid username and password
    When user enters valid username and password
    And user clicks on login button
    Then user is able to logged in successfully.