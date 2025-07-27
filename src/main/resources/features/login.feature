Feature: To check the login functionality working fine

  Scenario: Checking login functionality

    Given User navigate to login page
    When User enter username and password
    And User click on login button
    Then User should navigate to Home page


