Feature: Update User

  @Latihan
  Scenario: PUT update user with valid parameter id and JSON
    Given PUT Update User with valid id 2 and json
    When Send request PUT Update User
    Then Status code should be 200 OK
    And Response body name was "humam zaky" and job was "apaja yang penting halal"