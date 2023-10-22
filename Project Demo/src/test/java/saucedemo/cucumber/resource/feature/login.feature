Feature: Login functionality
  @positive
  Scenario: success login with valid credentials
    Given User is on login page
    When User enters username
    When  User enters password
    And Click login button
    Then User on dashboard page

  @Negative
  Scenario: failed login
    Given User is on login page
    When User enters invalid username
    And User enters password
    Then User is navigated to the home page

