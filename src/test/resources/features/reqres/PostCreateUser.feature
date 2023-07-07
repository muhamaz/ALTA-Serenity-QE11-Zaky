Feature: Create new user
  @Latihan
  Scenario: POST Create new user with valid JSON
    Given POST Create user with JSON "CreateNewUser.json"
    When Send request POST create user
    Then Status code should be 201 Created
    And Response body name was "humam" and job was "zaky"

  @Tugas
  Scenario Outline: POST Create new user with invalid JSON
    Given POST Create user with JSON <jsonName>
    When Send request POST create user
    Then Status code should be <statusCode> Bad Request
    Examples:
      | jsonName                  | statusCode |
      | "InvalidCredentials.json" | 400        |
      | "CreateAllEmpty.json"     | 400        |
      | "CreateEmptyName.json"    | 400        |
      | "CreateEmptyJob.json"     | 400        |

