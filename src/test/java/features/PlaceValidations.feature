Feature: Validating Place APIs

  @ADDPLACE1 @REGRESSION
  Scenario Outline: Verify if the place is being added.
    Given Add place payload "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" using "Post" request
    Then API response with status code 200
    And "status" response should be "OK"
    And "scope" response should be "APP"
    And Verify "GetPlaceAPI" with place_id of "<name>"


    Examples:
      |name |language |address|
      |water |English  |Bengaluru|
     # |G-two|Kannada  |Wow      |

  @ADDPLACE2
  Scenario Outline: Verify if the place is being added.
    Given Add place payload "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" using "Post" request
    Then API response with status code 200
    And "status" response should be "OK"
    And "scope" response should be "APP"
    And Verify "GetPlaceAPI" with place_id of "<name>"

    Examples:
      |name |language |address|
      #|water |English  |Bengaluru|
      |G-two|Kannada  |Wow      |