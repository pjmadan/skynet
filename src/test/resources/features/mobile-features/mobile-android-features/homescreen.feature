@android @mobile @ignore
Feature: High Charts app home screen
  Background:
    Given an end user has installed the Hello Charts Android application and has launched it and is on the home screen


@android
  Scenario: Line Chart
    When I click on Line Chart button
    Then I should see a the label for Linechartactivity
    And  I should see a Line Chart

@android
  Scenario: Column Chart
    When I click on ColumnChartActivity button
    Then I should see a the label for ColumnChartActivity
    And  I should see a Column Chart
