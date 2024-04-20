@api
Feature: Validate the list of movies, director and producer names

  Background:
    Given that I set the base URL "https://swapi.dev/api" for API
    When I set the resource "films/" for the API

    Scenario: Verify that there are 6 Movies, director of the 3rd movie and 5th movie director is invalid
      Then I list all "6" movies
      When I retrieve the title of the third movie "Return of the Jedi"
      And I retrieve the name of the director of the third move "Richard Marquand"
      And I retrieve the title of the fifth movie "Attack of the Clones"
      Then I confirm that "Gary Kurtz" and "George Lucas" are not producers of the fifth movie

