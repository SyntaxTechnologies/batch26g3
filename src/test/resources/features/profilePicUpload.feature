@tamana
Feature: Profile Picture Upload for ESS Users

  Background:
    Given user is able to launch HRMS application
    When user enters valid username and password
    And user clicks on login button

  @tamana
  Scenario: Upload valid profile picture
    When the user navigates to the personal profile picture section
    And the user selects a valid profile picture file to upload
    And the user clicks the upload save button
    Then the user should see their updated profile picture on the page

  @tamana
  Scenario: Attempt to upload invalid file format
    When the user navigates to the personal profile picture section
    And the user selects an invalid file format to upload
    Then the system should display an error message regarding file format