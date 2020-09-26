@productionLogin
Feature: Checking the production login with valid and invalid credentials

  Scenario: Testing the login page with valid credentials
    Given User is on the login page
    When entered valid username
    And entered valid password
    Then user should visit the homepage
