Feature: Create project
  Description: Client creates a new internal or external project
  Actor: Client

  # Main scenario
  Scenario: create internal project as a client
    Given the client is registered with the planningTool
    When the client requests to create an internal project
    And the client provides the project with name "p1"
    Then the planningTool creates a project with no project manager no developers and no project activities
    And the project is named "p1", has a project number and is internal

  # Alternate scenario 1
  Scenario: create external project as client
    Given the client is registered with the planningTool
    When the client requests to create an external project
    And the client provides the project with name "p1"
    Then the planningTool creates a project with no project manager, no developers and no project activities
    And the project is named "p1", has a project number and is external

  # Fail scenario 1
  Scenario: create project as a developer
    Given the developer is registered with the planningTool
    When the developer requests to create a project
    Then the planningTool provides an error message "Only clients can create projects."

  # Fail scenario 2
  Scenario: create project as a developer
    Given the developer is registered with the planningTool
    When the developer requests to create a project
    Then the planningTool provides an error message "Only clients can create projects."

  # Fail scenario 3
  Scenario: create project without a name
    Given the client is registered with the planningTool
    When the client requests to create a project
    And the client does not provide the project with a name
    Then the planningTool provides an error message "The project must be given a name"
