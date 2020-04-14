Feature: Register regular activities
  Description: A developer registers a regular activity
  Actors: Developer

  Scenario: Developer registers vacation when available
    Given a developer is registered with the planningTool
#    Given a developer has no activities from week 12 to 14
#    When the developer registers vacation in those weeks
#    Then the vacation is registered in the planningTool
#    And the developer is unavailable in those weeks