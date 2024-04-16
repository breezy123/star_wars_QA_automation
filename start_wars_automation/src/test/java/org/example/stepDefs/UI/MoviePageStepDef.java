package org.example.stepDefs.UI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static org.example.UI.core.Base.*;
import static org.example.stepDefs.UI.MenuPageStepDefs.pgObs;

public class MoviePageStepDef {
    @When("I click on the {string} movie option")
    public void iClickOnTheMovieOption(String element)throws Exception {
        Assert.assertTrue(click.ClickElementByxPath(pgObs.pageElement(element)));
    }
    @And("I scroll element {string} into view")
    public void iScrollElementIntoView(String element)throws Exception {
        Assert.assertTrue(scrollToView.ScrollToElementByxPath(pgObs.pageElement(element)));
    }
    @Then("I validate the speccy {string}")
    public void iValidateTheSpeccy(String element) {
        Assert.assertTrue(waits.waitForElementByXpath(pgObs.pageElement(element)));
    }
    @Then("I confirm that planet {string} is not part of The_Phantom_Menace movie")
    public void iConfirmThatPlanetIsNotPartOfThe_Phantom_MenaceMovie(String element) {
        Assert.assertFalse(waits.waitForElementByXpath(pgObs.pageElement(element)));
    }
}
