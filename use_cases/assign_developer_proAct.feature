Feature: Assign developer to project activity
  Description: Client and project manager assigns a developer an activity
  Actor: Client, Project manager

# Main scenario
  Scenario: Assign available developer an activity as a client
    Given a client is registered with the planningTool
    And a developer is registered with the planningTool
    And a project is defined within the planningTool
    And an activity is defined within the project for week 12 to 14
    And the developer is available for those weeks
    When the client assigns the developer the activity
    Then the activity has that developer assigned

# Alternative scenario 1
  Scenario: Assign available developer an activity as a project manager
    Given a project manager is registered with the planningTool
    And a developer is registered with the planningTool
    And a project is defined within the planningTool
    And the project manager manages a project defined within the planningTool
    And an activity is defined within the project for week 12 to 14
    And the developer is available for those weeks
    When the project manager assigns the developer the activity
    Then the activity has that developer assigned

# Fail scenario 1
  Scenario: Assign unavailable developer an activity as a project manager
    Given a project manager is registered with the planningTool
    And a developer is registered with the planningTool
    And a project is defined within the planningTool
    And an activity is defined within the project for week 13 to 14
    And the developer is not available for those weeks
    When the project manager assigns the developer the activity
    Then the planningTool provides an error message "This developer is not available in the project activity duration period."

 # Fail scenario 2
  Scenario: Assign developer who already has 20 activities assigned
    Given a project manager is registered with the planningTool
    And a developer is registered with the planningTool
    And a project is defined within the planningTool
    And an activity is defined within the project for week 12 to 14
    And the developer is assigned 20 activities
    When the project manager assigns the developer the activity
    Then the planningTool provides an error message "This developer is unavailable for the period, as they have reached their maximum amount of assigned activities."