Feature: Add project activity
  Description: Add project activity to project
  Actors: Project manager, client

# Main scenario
  Scenario: Add activity to project as project manager
    Given the project manager is registered with the planningTool
    And the project manager manages a project defined within the planningTool
    When the project manager creates a project activity within that project
    Then the project has that project activity

# Alternative scenario
  Scenario: Add activity to project as client
    Given the client is registered with the planningTool
    And a project is defined within the planningTool
    When the client creates a project activity within that project
    Then the project has that project activity

# Fail scenario
  Scenario: Add activity to project as developer
    Given the developer is registered with the planningTool
    And a project is defined within the planningTool
    When the developer creates a project activity within that project
    Then the project does not have that project activity
    And the planningTool provides an error message "As a developer, you do not have authority to add project activities. Instead, refer to the project manager."