Feature: Register working hours for project activities
  Description: Developer registers working hours for assigned project activities
  Actor: Developer, project manager

# Main scenario
  Scenario: register working hours for an activity
    Given an developer with initials "ABCD" is registered with the planningTool
    And a project activity is defined from week 12 to 14
    And a registered developer is assigned the activity "proAct"
    When the developer register hours for the activities
    Then the hours are registered

# Alternative scenario
  Scenario: register hours worked for every guest activity
    Given developer with initials "abcd" is assigned to an activity
    When developer "abcd" asks for assistance from developer "bcde"
    Then the developer with initial "bcde" is set as guest developer
    When the developer with initial "bcde" register hours for assigned activities
    And the developer with initial "bcde" registers hours for guest activities
    Then the hours are registered

# Alternative scenario
  Scenario: register hours so that an activity is finished
    Given a developer is registered with the planningTool
    And the developer is assigned to at least one activity
    When the employee register hours for the activities
    Then the hours are registered
    When the activity has no hours left
    Then the activity is marked as finished