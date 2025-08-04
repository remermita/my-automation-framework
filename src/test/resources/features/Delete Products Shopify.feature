@DeleteProduct
Feature: Delete Products in shopify
  Scenario Outline: Delete Products for Specific Players
    Given I am logged into the Shopify admin portal
    When I search for the product of "<playerName>" and "<school>"
    And I delete the product if it exists
    Then the product for "<playerName>" and "<school>" should be removed

    Examples:
    | playerName |  school  |
    | Drew Klein | NDSU |


