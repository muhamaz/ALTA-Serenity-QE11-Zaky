Feature: Login User

  @Tugas
  Scenario: POST Login Successfully
    Given POST Login with valid JSON "ValidLogin.json"
    When Send request POST Login
    Then Status code should be 200 OK
    And Response body should be display token "QpwL5tke4Pnpja7X4"
    And Validate with JSON schema "LoginSuccessSchema.json"

  @Tugas
  Scenario Outline: POST Login Unsuccessfully
    Given POST Login with invalid JSON <jsonName>
    When Send request POST Login
    Then Status code should be <statusCode> Bad Request
    And Response body should be display error <errorMsg>
    And Validate with JSON schema <jsonSchName>
    Examples:
      | jsonName                  | statusCode | errorMsg                    | jsonSchName                 |
      | "LoginAllEmpty.json"      | 400        | "Missing email or username" | "LoginUnsuccessSchema.json" |
      | "LoginEmptyEmail.json"    | 400        | "Missing email or username" | "LoginUnsuccessSchema.json" |
      | "LoginEmptyPassword.json" | 400        | "Missing password"          | "LoginUnsuccessSchema.json" |
      | "InvalidCredentials.json" | 400        | "user not found"            | "LoginUnsuccessSchema.json" |