Feature: Update regular activities and working hours
  Description: A developer wants to update a previous registration
  Actors: Developer

# Main scenario
  Scenario: Cancel a regular activity
    Given a developer with initials "ABCD" is registered with the planningTool
    And the developer has a vacation called "Mallorca" registered one month ahead
    When the developer cancels the "Mallorca" activity
    Then the vacation is canceled

# Alternative scenario
  Scenario: change week of regular activity
    Given an employee with initials "ABCD" is registered with the planningTool
    And the employee has a vacation registered for week 30
    When the employee updates the vacation from week 30 to week 32
    Then the employee has registered vacation for week 32

# Fail scenario
  Scenario: Update activity dates to dates in the past
    Given a developer with initials "ABCD" is registered with the planningTool
    And the developer has a vacation registered one month ahead
    When the developer updates the date of the vacation to a date two weeks before current date
    Then the error message "Cannot edit dates of activities to dates in the past."