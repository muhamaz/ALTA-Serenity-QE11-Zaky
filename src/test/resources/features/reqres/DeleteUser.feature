Feature: Delete user

  @Latihan
  Scenario: DELETE user with valid parameter id
    Given DELETE User with id 2
    When Send request DELETE User
    Then Status code should be 204 No Content

  @Tugas
  Scenario Outline: DELETE user with invalid parameter id
    Given DELETE User with id <id>
    When Send request DELETE User
    Then Status code should be <statusCode> Not Found
    Examples:
      | id | statusCode |
      | 13 | 404        |
      | 99 | 404        |