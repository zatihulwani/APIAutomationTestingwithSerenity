@zatihulwani
Feature: Reqresin

  @positive
  Scenario: Success GET users
    When user send GET Users request to reqresin
    Then response status code should be 200
    And response structure should match json schema "users.json"
#    And response path "page" should contain Int value "2"
#    And response path "data[0].first_name" should contain String value "Michael"

  @positive
  Scenario: Success POST Register
    When user send POST Register request to reqresin
    Then response status code should be 200
    And response structure should match json schema "register.json"

  @positive
  Scenario: Success POST login
    When user send POST login request to reqresin
    Then response status code should be 200
    And response structure should match json schema "login.json"

  @positive
  Scenario: Success PUT Update
    When user send PUT Update request to reqresin
    Then response status code should be 200
    And response structure should match json schema "update-user.json"

  @negative
  Scenario: Unsuccessful POST login
    When user send POST unsuccess login request to reqresin
    Then response status code should be 400
    And response structure should match json schema "unsuccess-login.json"

  @negative
  Scenario: Unsuccessful POST Register
    When user send POST unsuccess Register request to reqresin
    Then response status code should be 400
    And response structure should match json schema "unsuccess-regist.json"

  @negative
  Scenario: Unsuccessful GET Single User
    When user send GET single user request to reqresin
    Then response status code should be 404
    And response structure should match json schema "single-user-notfound.json"

  @negative
  Scenario: DELETE User
    When user send DELETE user request to reqresin
    Then response status code should be 204