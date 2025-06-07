Feature: Amazon Product Search

  Scenario Outline: Search for a product on Amazon
    Given I am on the Amazon homepage
    When I search for "<product>"
    Then I should see search results for "<product>"

    Examples:
      | product     |
      | laptop      |
      | headphones  |