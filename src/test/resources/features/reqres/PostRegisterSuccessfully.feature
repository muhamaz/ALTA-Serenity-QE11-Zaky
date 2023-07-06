Feature: Register user

  Scenario: POST Register User with valid JSON
    Given POST Register user with valid JSON "ValidRegister.json"
    When Send request POST Register user
    Then Response status code should be 201 Created
    And Response body id was "4" and token was "QpwL5tke4Pnpja7X4"