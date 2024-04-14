@ui
Feature: Validate that the given Planet is not part of a Movie

  Background:
    Given I navigate to the Star Wars website "http://localhost:3000/"

  Scenario: Assert that ‘Planets’ ‘Camino’ is not part of the movie ‘The Phantom Menace’
    When I click on the "The_Phantom_Menace" movie option
    And I scroll element "Planets" into view
    Then I confirm that planet "Camino" is not part of The_Phantom_Menace movie
    


