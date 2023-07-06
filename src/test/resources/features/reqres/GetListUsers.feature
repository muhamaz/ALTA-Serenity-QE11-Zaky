Feature: Get List All Users

  @Latihan
  Scenario: GET List users with valid parameter page
    Given GET list users with valid parameter page 2
    When Send request GET list users
    Then Status code should be 200 OK
    And Response body page value should be 2
