Feature: Generate project report
  Description: Project manager generates a project report from the planningTool
  to get an overview of the current hours worked on a project
  Actor: Project manager

# Main scenario
  Scenario: Generate project report from an existing project
    Given a project manager is registered with the planningTool
    And a project called "E-Receipt" is defined in the planningTool
    And multiple activities are defined within the project for week 12 to 14
    And developers are assigned activities
    And activities have registrations of hours worked from developers
    When the project manager requests a project report of "E-Receipt"
    Then a project report is generated
    And the project report contains an overview of active activities and their estimated time versus hours worked
    And an overview of developer registration

# Alternative scenario 1
  Scenario: Generate project report with guest developers
    Given a project manager is registered with the planningTool
    And a project called "E-Receipt" is defined in the planningTool
    And multiple activities are defined within the project for week 12 to 14
    And developers are assigned activities
    And activities have registrations of hours worked from guests- and developers
    When the project manager requests a project report
    Then a project report is generated
    And the project report contains an overview of active activities and their estimated time versus hours worked
    And an overview of developer registration
    And an overview of guest developer registration

# Alternative scenario 2
  Scenario: Generate project report with finished activities
    Given a project manager is registered with the planningTool
    And a project called "E-Receipt" is defined in the planningTool
    And multiple activities are defined within the project for week 12 to 14
    And developers are assigned activities
    And activities have registrations of hours worked
    And some activities are finished
    When the project manager requests a full project report of "E-Receipt"
    Then a project report is generated
    And the project report contains an overview of active and finished activities and their estimated time versus hours worked

# Fail scenario 1
  Scenario: Request a report of a project not defined in the planningTool
    Given a project manager is registered with the planningTool
    And the project "E-Receipt" is not defined in the planningTool
    When the project manager requests a project report of "E-Receipt"
    Then the planningTool provides the error message "The requested project is not defined in PlanningTool"
