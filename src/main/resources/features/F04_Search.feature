@smoke
Feature: F04_user search functionality
  As a user
  I want to be able to search for products
  So that I can find what I'm looking for
  Scenario Outline: user could search using product name
    When I add product name "<Email>"and  click
    Then user find all relevant results related to that name


    Examples:
      |  |