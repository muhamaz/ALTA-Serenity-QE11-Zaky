Feature: Create new user
  @Latihan
  Scenario: POST Create new user with valid JSON
    Given POST Create user with valid JSON
    When Send request POST create user
    Then Response status code should be 201 Created
    And Response body name was "humam" and job was "zaky"

