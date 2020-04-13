Feature: Create project
  Description: Client creates a new internal or external project
  Actors: Client

  Scenario: Create internal project as a client
    Given the client is registered with the planningTool
    When the client requests to create an internal project
    And the client provides the project with name "p1"
    Then the planningTool creates an empty project
    And the project is named "p1", has a project number and is internal