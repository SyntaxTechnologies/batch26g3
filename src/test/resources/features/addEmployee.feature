Feature: Adding employee to HRms Application
  Background:
    When user login to HRms application
    And user navigate to PIM page
    And user clicks on Add button
  @mustafa
  Scenario: Adding employee without the employee Id
    And user fill the fields except employee id
    And user clicks on save button
    Then system should generate employee id
    @mustafa
    Scenario: adding employee with the employee Id
      And user fill the fields
      And user clicks on save button
      Then employee is saved successfully
    @mustafa
    Scenario: Incomplete employee information
      And a required field is empty
      And user clicks on save
      Then error message should be displayed