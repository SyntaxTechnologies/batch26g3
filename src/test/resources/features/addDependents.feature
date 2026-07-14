Feature: Adding Dependent
  Background:
Given user is logged in.
    And navigate to My info page dependents section
@Mustafa
    Scenario: existing of name, relationship and date of birth fields
      When user clicks on the add button
      Then name, relationship and date of birth fields appear

