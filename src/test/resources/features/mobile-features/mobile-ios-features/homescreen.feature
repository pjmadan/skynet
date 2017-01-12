@ios @mobile
Feature: Deportes app home screen
  Background:
    Given an end user has installed the Deportes iOS application and has launched it and is on the home screen


  @ios
  Scenario: Click on first content
    When I click on the first content displayed on the app
    Then I should see the content load correctly


