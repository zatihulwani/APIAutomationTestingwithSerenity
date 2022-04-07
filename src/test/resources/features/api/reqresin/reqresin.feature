@wani
Feature: Reqresin

  Scenario: Success GET users
    When user send GET Users request to reqresin
    Then response status code should be 200
    And response structure should match json schema "users.json"
#    And response path "page" should contain Int value "2"
#    And response path "data[0].first_name" should contain String value "Michael"


  Scenario: Success POST login
    When user send POST login request to reqresin
    Then response status code should be 200


  Scenario: Success PUT Update
    When user send PUT Update request to reqresin
    Then response status code should be 200