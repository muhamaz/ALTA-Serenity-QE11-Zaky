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
    Given GET Single user with valid user id 2
    When Send request GET Single user
    Then Status code should be 200 OK
    And Response body user id should be 2
@Tugas
  Scenario: GET Single user with invalid id
    Given GET Single user with valid user id 23
    When Send request GET Single user
    Then Status code should be 404 Not Found
@Tugas
  Scenario: POST Login Successfully
    Given POST Login with valid JSON
#    Given POST Login with valid email "eve.holt@reqres.in" and password "cityslicka"
    When Send request POST Login
    Then Status code should be 200 OK
    And Response body should be display token "QpwL5tke4Pnpja7X4"

  Scenario Outline: POST Login Unsuccessfully
    Given POST Login with invalid email <email> and password <password>
    When Send request POST Login
    Then Status code should be <statusCode> Bad Request
    And Response body should be display error <errorMsg>
    Examples:
      | email                | password     | statusCode | errorMsg                    |
      | "eve.holt@reqres.in" | ""           | 400        | "Missing password"          |
      | ""                   | "cityslicka" | 400        | "Missing email or username" |
      | ""                   | ""           | 400        | "Missing email or username" |
