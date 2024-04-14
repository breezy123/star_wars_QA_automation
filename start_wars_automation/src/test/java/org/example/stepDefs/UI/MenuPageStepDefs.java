package org.example.stepDefs.UI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.UI.pageobjects.PageObjects;
import org.testng.Assert;

import static org.example.UI.core.Base.*;

public class MenuPageStepDefs {
    public static PageObjects pgObs = new PageObjects();
    @Given("I navigate to the Star Wars website {string}")
    public void iNavigateToTheStarWarsWebsite(String url) {
        navigate.NavigateToSite(url);
    }
    @When("I click on the {string} field")
    public void iClickOnTheField(String element) {
        Assert.assertTrue(click.ClickElementByxPath(pgObs.pageElement(element)));
    }
    @And("I retrieve all six movie titles {string}")
    public void iRetrieveAllSixMovieTitles(String element) {
        Assert.assertTrue(tables.getColumnDataByXpath(pgObs.pageElement(element)));
    }
    @Then("I validate that the last movie in the list is {string}")
    public void iValidateThatTheLastMovieInTheListIs(String movieTitle) {
        Assert.assertTrue(tables.getLastIndexValue(movieTitle));
    }
}
