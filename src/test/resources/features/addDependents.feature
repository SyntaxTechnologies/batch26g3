Feature: Add Dependents to Employee Profile

  Background:
    Given user is able to launch HRMS application
    When user enters valid username and password
    And user clicks on login button

  @tamana
  Scenario: Successfully add a dependent

    When the user navigates to the dependents section
    And the user enters "Salman Khan" as the dependent name
    And the user selects "Child" from the relationship dropdown
    And the user selects "2015-08-12" from the date of birth calendar
    And the user clicks the save dependent button
    Then the dependent "Salman Khan" should be displayed in the dependents list
    And the dependent record should be verified in the database

