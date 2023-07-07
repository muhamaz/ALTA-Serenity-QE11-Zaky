Feature: Update User

  @Latihan
  Scenario: PUT update user with valid parameter id and JSON
    Given PUT Update User with id 2 and json "UpdateUser.json"
    When Send request PUT Update User
    Then Status code should be 200 OK
    And Response body name was "humam zaky" and job was "apaja yang penting halal"
    And Validate with JSON schema "UpdateUserSchema.json"

  @Tugas
  Scenario Outline: PUT update user with invalid JSON
    Given PUT Update User with id <id> and json <jsonName>
    When Send request PUT Update User
    Then Status code should be <statusCode> Bad Request
    Examples:
      | id | jsonName                    | statusCode |
      | 2  | "UpdateInvalidReqBody.json" | 400        |
      | 2  | "UpdateAllEmpty.json"       | 400        |
      | 2  | "UpdateEmptyJob.json"       | 400        |
      | 2  | "UpdateEmptyName.json"      | 400        |

  @Tugas
  Scenario: PUT update user with invalid id
    Given PUT Update User with id 99 and json "UpdateUser.json"
    When Send request PUT Update User
    Then Status code should be 400 Bad Request
