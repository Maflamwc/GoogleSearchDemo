Feature: test

  Background:
    Given I'm on the google homepage

  @EXECUTE
  Scenario: The result match with "The Name of The Wind - Patrick Rothfuss"
    When I search for "The Name of The Wind" in Google
    Then The first result match with "The Name of The Wind"

  @EXECUTE
  Scenario: The first result match with "The Name of The Wind - Patrick Rothfuss"
    Given I search for "The Name of The Wind" on Google Search Page
    When I click on the first result
    Then I go to the "Patrick Rothfuss - the Books" page

  @EXECUTE
  Scenario: The suggestions search match with "The Name of The Wind - Patrick Rothfuss"
    When I type "The Name of The W" on Google Search Page
    And I select the first suggestion
    Then The first result match with "Patrick Rothfuss - the Books"


