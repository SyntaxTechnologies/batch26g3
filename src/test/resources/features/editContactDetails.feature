Feature: As an enmployee I want to be able to update my contact details
  Background:
    Given the employee is logged into the HRMS application
    And the employee navigates to the My Info page
    And the employee opens the Contact Details section

  @mustafa
  Scenario: Scenario: Verify all contact detail fields are displayed
    Then the Address Street 1 field should be displayed
    And the Address Street 2 field should be displayed
    And the City field should be displayed
    And the State field should be displayed
    And the Zip Code field should be displayed
   And the Country dropdown should be displayed
    And the Home Phone field should be displayed
    And the Mobile Phone field should be displayed
    And the Work Phone field should be displayed
    And the Work Email field should be displayed
    And the Other Email field should be displayed
    And the Save button should be displayed
  @mustafa
  Scenario: Successfully update employee contact details
    When the employee updates the contact details with:
      | Address Street 1 | 123 Main Street     |
      | Address Street 2 | Apartment 10        |
      | City             | Anaheim             |
      | State            | California          |
      | Zip Code         | 92801               |
      | Country          | United States       |
      | Home Phone       | 7145551111          |
      | Mobile Phone     | 7145552222          |
      | Work Phone       | 7145553333          |
      | Work Email       | user@company.com    |
      | Other Email      | user@gmail.com      |
    And the employee clicks the Save button
    And the employee refreshes the page
    Then the previously saved contact details should still be displayed