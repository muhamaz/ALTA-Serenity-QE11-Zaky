Feature: Get List All Resources

  @Tugas
  Scenario: GET List Resource with valid parameter page
    Given GET list Resource with valid parameter page 2
    When Send request GET list Resource
    Then Status code should be 200 OK
    And Response body page value should be 2
    And Validate with JSON schema "ListResourceSchema.json"

  @Tugas @Bug
  Scenario: GET List Resource with invalid parameter page
    Given GET list Resource with invalid parameter page "xyz"
    When Send request GET list Resource
    Then Status code should be 404 Not Found