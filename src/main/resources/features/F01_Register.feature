@smoke
Feature: F01_Register | users could register with new accounts
  Scenario Outline: guest user could register with valid data successfully
    Given user go to register page
    When user select gender "<type>"
      And user enter "<first name>"and"<last name>"
      And user enter date of birth "<date of birth>"
      And user enter email "<Email>" field
      And user enter company name "<company>" field
      And user fills Password fields "<password>" and confirm
   Then user clicks on register button
      And success message is displayed




 Examples:
  | first name | last name |type|date of birth|     Email         |company   |password |
  |automation  |  tester   |male|  13/6/1998  |test109@example.com|happy time|P@sssw0rd |
