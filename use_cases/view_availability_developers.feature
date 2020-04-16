Feature: View availability status of all developers
  Description: Project manager or client views the availability status
  of all developers
  Actors: Project manager, client

  # Main scenario
  Scenario: view table of developer availability as a client
    Given the client is registered with the planningTool
    And one or more developers are registered with the planningTool
    When the client requests to view the availability status
    Then the planningTool displays a table containing the availability status of all registered developers and their initials

# Alternate scenario 1
  Scenario: view table of developer availability as a project manager
    Given the project manager is registered with the planningTool
    And one or more developers are registered with the planningTool
    When the project manager requests to view the availability status
    Then the planningTool displays a table containing the availability status of all registered developers and their initials

# Fail scenario 1
  Scenario: view availability table as developer
    Given the developer is registered with the planningTool
    And one or more developers are registered with the planningTool
    When the developer requests to view the availability status
    Then the planningTool provides the error message "As a developer, you do not have the authority to view developer availability status."