Feature: Executing UI scripts

  Scenario: Finding some cheese through google search
    Given I am on the Google search page
    When I search for "Selenium"
    Then the page title should start with "Selenium - Google Search"
    And user click on "Selenium" header text
    And user navigates to home page of "Selenium"
