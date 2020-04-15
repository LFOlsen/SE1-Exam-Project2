Feature: Register regular activities
  Description: A developer registers a regular activity
  Actors: Developer

  #Main scenario
  Scenario: Developer registers vacation when available
    Given a developer is registered with the planningTool
    And the developer has no activities from week 12 to 14
    When the developer registers vacation from week 12 to 14
    Then vacation is registered in the planningTool from week 12 to 14
    And the developer is unavailable from week 12 to 14

  #Fail scenario
  Scenario: Developer registers vacation when unavailable
    Given a developer is registered with the planningTool
    And the developer has a project activity from week 12 to 14
    When the developer registers vacation from week 12 to 14
    Then the error message "Vacation/seminar cannot be registered as you have project-activities in those weeks" is given