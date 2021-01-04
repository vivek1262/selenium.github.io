Feature: Opening Growth engineering website homepage

  Scenario: Click to Menu button in webpage
    Given I launch Chrome browser
    When I open Growth Engineering webpage
    Then I check the Menu options
    Then I click contact-button
    And close the browser