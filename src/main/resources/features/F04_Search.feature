@smoke
Feature: F04_user search functionality
  As a user
  I want to be able to search for products
  So that I can find what I'm looking for
  Scenario Outline: user could search using product name
    When I add product name "<item>"and  click
    Then user find size of all relevant results related to that name
    And check that results that contain searched word
    Examples:
      | item |
      | book |
      |laptop|
      |nike  |

  Scenario Outline: user could search using sku product name
    When I add  sku product name "<item>"and  click
    Then after searching click on first item
   And check that results that contain searched sku word



    Examples:
      | item      |
      | SCI_FAITH |
      |  APPLE_CAM|
    |  SF_PRO_11|