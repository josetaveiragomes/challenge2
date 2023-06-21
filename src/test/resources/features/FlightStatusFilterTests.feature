Feature: Flight Status Filter
  As a User, I can check the status of specific flights

  Background: Flight Status page of eurowings.com

  @ScenarioOutline
  Scenario Outline: Filter options with results
    Given I am in the Flight Status Page
    When I add "<departure>" as departure
    And I add "<destination>" as destination
    And I add "<date>" as date
    And I press the Show flight status button
    Then the flights should be for the date "<date>"
    And the flights should have a status
    Examples:
      | departure | destination | date     |
      | CGN       | BER         | today    |
#      | CGN       | BER         | tomorrow |