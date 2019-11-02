@web @regression @webprojecthotels @webprojecthotelshome
  Feature: Hotels Web Project Home

    Background:
      Given I am on the Hotels home page

      @FA2-311 @webproject_hotel_home_1
      Scenario Outline: Verify room count drop down
        When I select <number of rooms> from the rooms drop down list
        Then I verify the correct number of occupancy panels displayed is <expected>

        Examples:
          | number of rooms   | expected  |
          | 1                 | 1         |
          | 2                 | 2         |
          | 3                 | 3         |
          | 4                 | 4         |
          | 5                 | 5         |
          | 6                 | 6         |
          | 7                 | 7         |
          | 8                 | 8         |
          | 9+                | 0         |