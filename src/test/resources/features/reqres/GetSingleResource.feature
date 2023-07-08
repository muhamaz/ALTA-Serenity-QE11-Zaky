Feature: Get Single Resource

  @Tugas
  Scenario: Get Single Resource with valid parameter id
    Given GET Single Resource with valid parameter id 2
    When Send request GET Single Resource
    Then Status code should be 200 OK
    And Response body user id should be 2
    And Validate with JSON schema "SingleResourceSchema.json"

  @Tugas
  Scenario: Get Single Resource with invalid parameter id
    Given GET Single Resource with valid parameter id 23
    When Send request GET Single Resource
    Then Status code should be 404 Not Found