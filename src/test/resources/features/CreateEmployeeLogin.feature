Feature: Create a login account for employee by admin

Background:
  When user enters valid username and password
  And user clicks on login button
  Then user is able to logged in successfully.
  When admin clicks the Admin option
  And  admin clicks the User management option
  And admin clicks the Add button

  @create_employee_login @valid_employee_login
  Scenario: creating employee login details
    When the admin enters the userRole as "ESS", employee name as "test", status as "Enabled", username as "testUser",password as "Testpass@123" and confirm password as "Testpass@123"
    And user clicks save button
    Then the user login details are created successfully

  @create_employee_login @invalid
  Scenario: User Role left unselected
    When the admin enters the userRole as "-- Select --", employee name as "test", status as "Enabled", username as "testUser",password as "Testpass@123" and confirm password as "Testpass@123"
    And user clicks save button
    Then the error message "Required" is shown beside "user role" field

  @create_employee_login @invalid
  Scenario: Status left unselected
    When the admin enters the userRole as "ESS", employee name as "test", status as "-- Select --", username as "testUser",password as "Testpass@123" and confirm password as "Testpass@123"
    And user clicks save button
    Then the error message "Required" is shown beside "status" field

  @create_employee_login @invalid
  Scenario: Employee Name left empty
    When the admin enters the userRole as "ESS", employee name as "", status as "Enabled", username as "testUser",password as "Testpass@123" and confirm password as "Testpass@123"
    And user clicks save button
    Then the error message "Required" is shown beside "employee name" field

  @create_employee_login @invalid
  Scenario: User Name left empty
    When the admin enters the userRole as "ESS", employee name as "test", status as "Enabled", username as "",password as "Testpass@123" and confirm password as "Testpass@123"
    And user clicks save button
    Then the error message "Required" is shown beside "user name" field

  @create_employee_login @invalid
  Scenario: Password left empty
    When the admin enters the userRole as "ESS", employee name as "test", status as "Enabled", username as "testUser",password as "" and confirm password as "Testpass@123"
    And user clicks save button
    Then the error message "Required" is shown beside "password" field

  @create_employee_login  @negative
  Scenario: Confirm password does not match password
    When the user enters the  password as "Testpass@123" and confirm password as "Test"
    And user clicks save button
    Then the error message "Passwords do not match" is shown beside "confirm password" field

  @create_employee_login  @negative1
    Scenario Outline: Testing password rules
    When the user enters the  password as "<password_text>"
    And user clicks save button
    Then the error message "<error>" is shown beside "password" field
    Examples:
      | password_text    | error                                          |
      | pass1       | Should have at least 8 characters |
      | passwordtest | Your password must contain minimum 1 upper-case letter  |
      | Passwordtest |Your password must contain minimum 1 number |
      | Passwordtest123 | Your password must contain minimum 1 special character  |
