Feature: Request assistance
  Description: A developer requests assistance from another developer
  on a project activity
  Actors: Developer

# Main scenario
  Scenario: Developer requests assistance from available developer for entire activity
    Given a project activity "a1" is defined from week 12 to 14
    And a registered developer "ABCD" is assigned "a1"
    And another registered developer "BCDE" is available from week 12 to 14
    And "BCDE" is not assigned "a1"
    When "ABCD" requests assistance on project activity "a1" from "BCDE"
    Then "BCDE" assists on "a1" from week 12 to 14

# Alternative scenario
  Scenario: Developer requests assistance from available developer for part of the activity
    Given a project activity "a1" is defined from week 12 to 14
    And a registered developer "ABCD" is assigned "a1"
    And another registered developer "BCDE" is available from week 11 to 13
    And "BCDE" is not assigned "a1"
    When "ABCD" requests assistance on project activity "a1" from "BCDE"
    Then "BCDE" assists on "a1" from week 12 to 13

# Fail scenario 1
  Scenario: Developer requests assistance from unavailable developer
    Given a project activity "a1" is defined from week 12 to 14
    And a registered developer "ABCD" is assigned the activity
    And another registered developer "BCDE" is unavailable from week 12 to 14
    When "ABCD" requests assistance on project activity "a1" from "BCDE"
    Then the planningTool provides an error message "The requested developer is not available"

# Fail scenario 2
  Scenario: Developer requests assistance from available developer assigned the same activity
    Given a project activity "a1" is defined from week 12 to 14
    And a registered developer "ABCD" is assigned "a1"
    And another registered developer "BCDE" is available from week 12 to 14
    And "BCDE" is assigned "a1"
    When "ABCD" requests assistance on project activity "a1" from "BCDE"
    Then the planningTool provides an error message "The requested developer is not available"