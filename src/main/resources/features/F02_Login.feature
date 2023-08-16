@smoke
Feature: F02_Login | users could use login functionality to use their accounts
  Scenario Outline: user could login with valid email and password
  Given user go to login page
  When user login with valid Email"<Email>"and Password "<Password>"
    And user press on login button
  Then user login to the system successfully
    Examples:
      |       Email        | Password  |
      | test@example.com   | P@sssw0rd |

  Scenario Outline: user could login with invalid email and password
    Given user go to login page
    When user login with invalid Email"<Email>"and Password "<Password>"
    And user press on login button
    Then user can't login to the system successfully

    Examples:
    |     Email          | Password  |
    | test107@example.com| P@sssw0rd |

