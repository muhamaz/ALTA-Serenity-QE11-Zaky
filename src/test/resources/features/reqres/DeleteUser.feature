Feature: Delete user

  @Latihan
  Scenario: DELETE user with valid parameter id
    Given DELETE User with valid id 2
    When Send request DELETE User
    Then Status code should be 204 No Content