Feature: Register regular activities
  Description: A user of type developer registers a regular activity
  Actors: User of type developer

  #Main scenario
  Scenario: Developer registers vacation when available
    Given the registered user is a developer
    And the user has no activities from "01/04/2020" to "10/04/2020"
    When the user registers vacation from "01/04/2020" to "10/04/2020"
    Then vacation is registered in the planningTool from "01/04/2020" to "10/04/2020"
    And the user is unavailable from "01/04/2020" to "10/04/2020"

  #Alternative scenario
  Scenario: Developer registers sickness when assigned activities
    Given the registered user is a developer
    And the user has one activity from "01/04/2020" to "10/04/2020"
    When the user registers sickness from "01/04/2020" to "02/04/2020"
    Then sickness is registered in the planningTool from "01/04/2020" to "02/04/2020"
    And the user is unavailable from "01/04/2020" to "02/04/2020"

  #Fail scenario #1
  Scenario: Developer registers vacation when unavailable
    Given the registered user is a developer
    And the user has one activity from "01/04/2020" to "10/04/2020"
    When the user registers vacation from "01/04/2020" to "10/04/2020"
    Then the error message "Regular activity cannot be registered due to other activities occurring in that period" is given

  #Fail scenario #2
  Scenario: Client registers vacation
    Given the registered user is a client
    When the user registers vacation from "01/04/2020" to "10/04/2020"
    Then the error message "A client cannot register a regular activity" is given
