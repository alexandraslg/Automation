Feature: Calendar Test

  Scenario Outline: User creates a calendar event
    Given User is logged in with email "<email>", password "<password>", and phone number "<phoneNumber>"
    When User navigates to the specific day "<date>"
    And User creates a new event "<eventText>"
    Then The event "<eventText>" is present in the calendar
    Examples:
      | email                 | password         | phoneNumber | date          | eventText          |
      | testUser85@gmail.com  | pass12345        | 0846597541  | July 17, 2024 | Training with John |
      | testUser596@gmail.com | pass123235       | 0326458972  | July 17, 2024 | Training with Mark |
      | testUser876@gmail.com | pass123235fds    | 0326458973  | July 17, 2024 | Training with Mark |
      | testUser656@gmail.com | pass123235fsdf   | 0326458974  | July 17, 2024 | Training with Mark |
      | testUser454@gmail.com | pass12323sdfsdf5 | 0326458975  | July 17, 2024 | Training with Mark |
      | testUser216@gmail.com | pass12323sdf5    | 0326458976  | July 17, 2024 | Training with Mark |
      | testUser536@gmail.com | pass12323sdfdfs5 | 0326458977  | July 17, 2024 | Training with Mark |


