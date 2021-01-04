Feature: Login the application form
  I want to submit the login  form

  @tag1
  Scenario: Login form
    Given I open chrome browser
    Then I click the Get In Touch button
    And It opens Login page
    When I enter valid details
    When I entered no details in page 
    
