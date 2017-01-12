@sanity @regression
Feature:Flight Search


  Background:
  Given an end user has navigated to a website using a supported browser


  @valid @web
  Scenario: User enters a valid Destination and to and from dates
    When I enter destination as "SFO"
    And I enter CheckInDate as "2016-12-30"
    And I enter CheckOutDate as "2017-01-02"
    And I select Rooms as "1"
    And I click on Search
    Then I should see a list of hotels that match my criteria

  @invalid @regression @web
  Scenario Outline: User enters a valid Destination but invalid check in and check out dates
    When I enter destination as "<Destination>"
    And I enter CheckInDate as "<CheckinDate>"
    And I enter CheckOutDate as "<CheckoutDate>"
    And I select Rooms as "1"
    And I click on Search
    Then I should not see a list of hotels that match my criteria
    And I should see an error saying "the check in date should be before the check out date"

    Examples:
    | Destination | CheckinDate | CheckoutDate |
    |SFO          |2015-06-09   |2014-09-06    |
    |NY           |2019-09-06   |2018-09-12    |