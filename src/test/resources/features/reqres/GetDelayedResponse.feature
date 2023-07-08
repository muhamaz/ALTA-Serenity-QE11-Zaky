Feature: Delayed Response Time

  @Tugas
  Scenario: GET List User with delayed response time
    Given GET list user with parameter delay 3
    When Send request GET delayed response
    Then Status code should be 200 OK
    And Response time is 4500 milliseconds