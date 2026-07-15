Feature: Employee search scenarios


  Background:
    Given user is able to launch HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is able to logged in successfully.
    When user clicks on PIM option


  @pree
  Scenario: Search employee by full Name
  When user enters valid employee full name "Dayae Lazrak"
  And user clicks on search button
  Then user is able to see list of matched employees details

  @pree
  Scenario: Search employee by partial entering partial full name
      When user enters a partial full name name "Dave"
      And user clicks on search button
      Then user is able to see list of matched employees details

  @pree
  Scenario: Search employee by partial entering mixed of capitalization
    When user enters a mixed capitalization of valid employee full name "daVe"
    And user clicks on search button
    Then user is able to see list of matched employees details

  @pree
  Scenario: Search employee by employee ID
    When user enters valid employee id
    And user clicks on search button
    Then user is able to see the employee details

  @pree
  Scenario: Search employee by a not valid employee ID
    When user enters a not valid employee id
    And user clicks on search button
    Then user is able to see a message "No Records Found"







