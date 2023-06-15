@smoke
Feature: F03_Changing currency
    As a user, I want to be able to change the currency from the home page
    to get featured products in a currency that I had been chosen

  Scenario: From home page user could change the currency of featured products from dollar to Euro
    Given user navigate to home page
    When user Select "Euro" currency from the dropdown list on the top left of home page
    Then featured products currency changed successfully and check by currency symbol "€"