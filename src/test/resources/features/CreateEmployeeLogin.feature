Feature: Create a login account for employee by admin

Background:
  When user enters valid username and password
  And user clicks on login button
  Then user is able to logged in successfully.
  When admin clicks the Admin option
  And  admin clicks the User management option
  And admin clicks the Add button

  @create_employee_login @positive
  Scenario: creating employee login details
    When the admin enters the userRole as "ESS", employee name as "test", status as "Enabled", username as "testUser",password as "Testpass@123" and confirm password as "Testpass@123"
    And user clicks save button
    Then the user login details are created successfully

  @create_employee_login @negative
  Scenario Outline: Save fails when a required field is left empty
    When the admin enters the userRole as "<userRole>", employee name as "<employeeName>", status as "<status>", username as "<username>",password as "<password>" and confirm password as "<confirmPassword>"
    And user clicks save button
    Then the error message "Required" is shown beside "<field>" field

    Examples:
      | userRole    | employeeName | status     | username  | password     | confirmPassword | field         |
      | -- Select --| test         | Enabled    | testUser  | Testpass@123 | Testpass@123     | user role     |
      | ESS         | test         | -- Select --| testUser  | Testpass@123 | Testpass@123     | status        |
      | ESS         |              | Enabled    | testUser  | Testpass@123 | Testpass@123     | employee name |
      | ESS         | test         | Enabled    |           | Testpass@123 | Testpass@123     | user name     |
      | ESS         | test         | Enabled    | testUser  |              | Testpass@123     | password      |

  @create_employee_login  @negative
  Scenario: Confirm password does not match password
    When the user enters the  password as "Testpass@123" and confirm password as "Test"
    And user clicks save button
    Then the error message "Passwords do not match" is shown beside "confirm password" field

  @create_employee_login  @negative
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

  @create_employee_login  @ui
  Scenario Outline: Testing password strength
    When the user enters the  password as "<password_text>"
    Then the error message "<strength>" is shown beside "password strength" field
    Examples:
      | password_text    | strength  |
      | t      | Very Weak  |
      | testpas      | Weak  |
      | Test@pass  | Better  |
      | Testpass@123 | Strong  |
      | Testpass@123%45  | Strongest|
