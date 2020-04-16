Feature: Register regular activities
  Description: A developer registers a regular activity
  Actors: Developer

# Main scenario
  Scenario: Developer registers vacation when available
    Given a registered developer has no activities from week 12 to 14
    When the developer registers vacation in those weeks
    Then the vacation is registered in the planningTool
    And the developer is unavailable in those weeks

# Alternative scenario 1
  Scenario: Developer registers seminar when available
    Given a registered developer has no activities from week 12 to 14
    When the developer registers a seminar in those weeks
    Then the seminar is registered in the planningTool
    And the developer is unavailable in those weeks

# Alternative scenario 2
  Scenario: Developer registers sickness when available
    Given a registered developer is available from week 12 to 14
    When the developer registers sickness in those weeks
    Then the sickness is registered in the planningTool
    And the developer is unavailable in those weeks

# Alternative scenario 3
  Scenario: Developer registers sickness when assigned activities
    Given a project activity is defined from week 12 to 14
    And a registered developer is assigned the activity
    When the developer registers sickness from week 12 to 14
    Then the sickness is registered in the planningTool
    And the developer is unavailable in those weeks

# Fail scenario
  Scenario: Developer registers vacation when unavailable
    Given a project activity is defined from week 12 to 14
    And a registered developer is assigned the activity
    When the developer registers vacation from week 12 to 14
    Then the planningTool provides an error message "Vacation/seminar cannot be registered as you have project-activities in those weeks"