@ui
Feature: View movie and check for species

  Background:
    Given I navigate to the Star Wars website "http://localhost:3000/"

  Scenario: View the movie ‘The Empire Strikes Back’ and check if the ‘Species’ list has ‘Wookie’
    When I click on the "The_Empire_Strikes_Back" movie option
    And I scroll element "Species" into view
    Then I validate the speccy "Wookie"
    


