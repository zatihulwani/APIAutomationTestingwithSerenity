@register @staging @ALT-123
Feature: Register

  Background:
    Given user is on registration page

#  @positive
#  Scenario: Success Register
#    Given user set auth
#    When user send "GET" request to "https:reqresin"
#    Then response should be "200"
#
#  Scenario: Success Register
#    Given user set auth
#    When user send "GET" request to "https:reqresin/user"
#    Then response should be "200"
#
#  Scenario: Success Register
#    Given user set auth
#    When user send "GET" request to "https:reqresin/userasd"
#    Then response should be "404"

  @positive
  Scenario: Success Register
    And user input email data
    And user input password data
    And user input address data
    When user click register button
    Then user should be redirected to homepage


  @negative
  Scenario: Failed Register
    And user input email data
    And user input password data
    When user click register button
    Then user should be able to see warning message

  @positive
  Scenario: Register using google account
    When user click register with "google"
    Then user should be redirected to "google" page

  @positive
    Scenario: Register using facebook account
    When user click register with "facebook"
    Then user should be redirected to "facebook" page