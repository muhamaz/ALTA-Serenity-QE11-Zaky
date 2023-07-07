Feature: Register Successfully

  @Tugas
  Scenario: POST Register Successfully
    Given POST Register user with valid JSON "ValidRegister.json"
    When Send request POST Register user
    Then Status code should be 200 OK
    And Response body id was 4 and token was "QpwL5tke4Pnpja7X4"