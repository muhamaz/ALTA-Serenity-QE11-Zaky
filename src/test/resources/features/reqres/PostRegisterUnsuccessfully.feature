Feature: Register Unsuccessfully

  @Tugas
  Scenario Outline: POST Register Unsuccessfully
    Given POST Register user with invalid JSON <jsonName>
    When Send request POST Register user
    Then Status code should be <statusCode> Bad Request
    And Response body should be display error <errorMsg>
    Examples:
      | jsonName                     | statusCode | errorMsg                                        |
      | "RegisterEmptyPassword.json" | 400        | "Missing password"                              |
      | "RegisterEmptyEmail.json"    | 400        | "Missing email or username"                     |
      | "RegisterAllEmpty.json"      | 400        | "Missing email or username"                     |
      | "InvalidCredentials.json"    | 400        | "Note: Only defined users succeed registration" |