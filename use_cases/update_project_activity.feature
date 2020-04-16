Feature: Update project activity
  Description: Change working hours and schedule of project activity
  Actors: Project manager, client

  # Main scenario 1
  Scenario: Update working hours to project activity as project manager
    Given the project manager is registered with the planningTool
    And the project manager manages a project defined within the planningTool
    And the project has a project activity of 100 working hours
    When the project manager estimates 200 working hours for that project activity
    Then that activity has 200 working hours

  # Alternative scenario 1
  Scenario: Update working hours to project activity as client
    Given the client is registered with the planningTool
    And a project is defined within the planningTool
    And a project has a project activity of 131 working hours
    When the client estimates 22 working hours for that activity
    Then that activity has 22 working hours

  # Main scenario 2
  Scenario: Add schedule of project activity as project manager
    Given the project manager is registered with the planningTool
    And the project manager manages a project defined within the planningTool
    And the project has a project activity of 131 working hours
    When the project manager adds a start week: 7 and an end week: 10
    Then the project activity is defined from week 7 to 10

  # Alternative scenario 2
  Scenario: Add schedule of project activity as client
    Given the client is registered with the planningTool
    And a project is defined within the planningTool
    And the project has a project activity of 10 working hours
    When the client adds a start week: 22 and an end week: 23
    Then the project activity is defined from week 22 to 23

  # Main scenario 3
  Scenario: Update schedule as project manager
    Given the project manager is registered with the planningTool
    And the project manager manages a project defined within the planningTool
    And an activity is defined within the project for week 12 to 14
    When the project manager changes a start week: 3 and an end week: 4
    Then the project activity is defined from week 3 to 4

  # Alternative scenario 3
  Scenario: Update schedule as client
    Given the client is registered with the planningTool
    And a project is defined within the planningTool
    And an activity is defined within the project for week 12 to 14
    When the client changes a start week: 9 and an end week: 11
    Then the project activity is defined from week 9 to 11

  # Fail scenario
  Scenario: Update schedule as developer
    Given the developer is registered with the planningTool
    And a project is defined within the planningTool
    And an activity is defined within the project for week 12 to 14
    When the developer changes a start week: 9 and an end week: 11
    Then the project activity is defined from week 12 to 14