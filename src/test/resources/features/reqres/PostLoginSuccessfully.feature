Feature: Login Successfully

  @Tugas
  Scenario: POST Login Successfully
    Given POST Login with valid JSON "ValidLogin.json"
    When Send request POST Login
    Then Status code should be 200 OK
    And Response body should be display token "QpwL5tke4Pnpja7X4"