Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given I open the application
    When I enter username "Motala"
    And I enter password "password"
    And I click the login button
    Then I should be logged in successfully

  Scenario: Login with empty username and password
    Given I open the application
    When I enter username ""
    And I enter password ""
    And I click the login button
    Then I should see a validation error

  Scenario: Login with only username
    Given I open the application
    When I enter username "Motala"
    And I enter password ""
    And I click the login button
    Then I should see a validation error
