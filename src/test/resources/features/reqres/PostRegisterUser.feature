Feature: Register User

  @Tugas
  Scenario: POST Register Successfully
    Given POST Register user with valid JSON "ValidRegister.json"
    When Send request POST Register user
    Then Status code should be 200 OK
    And Response body id was 4 and token was "QpwL5tke4Pnpja7X4"
    And Validate with JSON schema "RegisterSuccessSchema.json"

  @Tugas
  Scenario Outline: POST Register Unsuccessfully
    Given POST Register user with invalid JSON <jsonName>
    When Send request POST Register user
    Then Status code should be <statusCode> Bad Request
    And Response body should be display error <errorMsg>
    And Validate with JSON schema <jsonSchName>
    Examples:
      | jsonName                     | statusCode | errorMsg                                        | jsonSchName                    |
      | "RegisterEmptyPassword.json" | 400        | "Missing password"                              | "RegisterUnsuccessSchema.json" |
      | "RegisterEmptyEmail.json"    | 400        | "Missing email or username"                     | "RegisterUnsuccessSchema.json"  |
      | "RegisterAllEmpty.json"      | 400        | "Missing email or username"                     | "RegisterUnsuccessSchema.json"  |
      | "InvalidCredentials.json"    | 400        | "Note: Only defined users succeed registration" | "RegisterUnsuccessSchema.json"  |