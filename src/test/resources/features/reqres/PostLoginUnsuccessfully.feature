Feature: Login Unsuccessfully

  @Tugas
  Scenario Outline: POST Login Unsuccessfully
    Given POST Login with invalid JSON <jsonName>
    When Send request POST Login
    Then Status code should be <statusCode> Bad Request
    And Response body should be display error <errorMsg>
    Examples:
      | jsonName                  | statusCode | errorMsg                    |
      | "LoginAllEmpty.json"      | 400        | "Missing email or username" |
      | "LoginEmptyEmail.json"    | 400        | "Missing email or username" |
      | "LoginEmptyPassword.json" | 400        | "Missing password"          |
      | "InvalidCredentials.json" | 400        | "user not found"            |