Feature: Create a login account for employee by admin
Background:
  When user enters valid username and password
  And user clicks on login button
  Then user is able to logged in successfully.

  @create_employee_login
  Scenario: creating employee login details
    When admin clicks the Admin option
    And  admin clicks the User management option
    And admin clicks the Add button
    When the admin enters the userRole as "ESS", employee name as "test", status as "Enabled", username,password and confirm password
    And user clicks save button
    Then the user login details are created successfully
