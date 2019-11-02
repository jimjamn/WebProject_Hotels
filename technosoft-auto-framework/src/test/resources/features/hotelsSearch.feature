@web @regression @webprojecthotels @webprojecthotelssearch
Feature: Hotels Web Project Search

  Background:
    Given I am on the Hotels search page using default values

  @FA2-303 @webproject_hotel_search_1
  Scenario Outline: Verify that only hotels which match star filter are displayed in search result
    When I select the <number_of_stars>-star checkbox in the Star Rating collapsible list
    Then I verify that only hotels which have a <number_of_stars>-star rating are displayed

    Examples:
      | number_of_stars |
      | 5               |
      | 4               |
      | 3               |

  @FA2-305 @webproject_hotel_search_2
  Scenario Outline: Verify that only hotels within the 0.5 miles of the City Center are displayed in search result
    When I click on the Landmarks filter in the filter panel
    And I select the <landmark> checkbox in the Landmarks collapsible list
    And I set the distance to be <distance_from_landmark> in the Distance drop down list
    Then I verify that the only hotels which are within <distance_from_landmark> from the <landmark> are displayed
    And I verify there is at least one Hilton Hotel displayed in the search results

  Examples:
    | landmark    | distance_from_landmark |
    | City Center | 0.5 miles              |


  @FA2-312 @webproject_hotel_search_3
  Scenario: Verify the Deal of the Day is less than $200
    Then I verify the Deal of the Day is displayed
    And I verify that the Deal of the Day is less than $200