Feature: Get Single User

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