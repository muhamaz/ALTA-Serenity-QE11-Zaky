Feature: API Automation Testing ALTA QE Batch 11
@Latihan
  Scenario: GET List users with valid parameter page
    Given GET list users with valid parameter page 2
    When Send request GET list users
    Then Status code should be 200 OK
    And Response body page value should be 2
@Latihan
  Scenario: POST Create new user with valid JSON
    Given POST Create user with valid JSON
    When Send request POST create user
    Then Response status code should be 201 created
    And Response body name was "humam" and job was "zaky"

@Tugas
  Scenario: GET Single user with valid id
    Given GET Single user with user id 2
    When Send request GET Single user
    Then Status code should be 200 OK
    And Response body user id should be 2
@Tugas
  Scenario: GET Single user with invalid id
    Given GET Single user with user id 23
    When Send request GET Single user
    Then Status code should be 404 Not Found
@Tugas
  Scenario: POST Login Successfully
    Given POST Login with valid JSON "ValidLogin.json"
    When Send request POST Login
    Then Status code should be 200 OK
    And Response body should be display token "QpwL5tke4Pnpja7X4"
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
