@api
Feature: Validate the list of planet names, population and climate

  Background:
    Given that I set the base URL "https://swapi.dev/api" for API
    When I set the resource "planets/" for the API

    Scenario: Check the total of planets, population and climate
      Then I list all names of the planets and search for planet "Endor"
      When I retrieve all population of those planets
      Then I also retrieve all weather climates of those planets


