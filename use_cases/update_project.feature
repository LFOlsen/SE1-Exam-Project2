Feature: Update project
  Description: Change project name
  Actors: Project manager, client

# Main scenario
  Scenario: Change project name as project manager
    Given the project manager is registered with the planningTool
    And the project manager manages a project defined within the planningTool
    When the project manager changes the project name to "New Project Name"
    Then that project has the name "New Project Name"

# Alternative scenario
  Scenario: Change project name as client
    Given the client is registered with the planningTool
    And a project is defined within the planningTool
    When the client changes the project name to "Better Project Name"
    Then that project has the name "Better Project Name"

# Fail scenario
  Scenario: Name project as developer
    Given the developer is registered with the planningTool
    And a project is defined within the planningTool
    When the developer changes the project name to "Worse Project Name"
    Then that project name is unchanged
