@ui
Feature: Sort movie by title and validate last movie

  Background:
    Given I navigate to the Star Wars website "http://localhost:3000/"

  Scenario: Sort movies by ’Title’ and assert the last movie in the list is ‘The Phantom Menace’
    When I click on the "Title_Column" field
    And I retrieve all six movie titles "Column_Title_Data"
    Then I validate that the last movie in the list is "The Phantom Menace"



