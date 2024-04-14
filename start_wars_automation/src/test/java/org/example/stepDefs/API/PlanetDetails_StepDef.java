package org.example.stepDefs.API;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;

import static org.example.stepDefs.API.MovieDetails_StepDef.jsPath;

public class PlanetDetails_StepDef {
    String planetName="";
    int getTotalPlanets=0;
    ArrayList<String> planetsArray;
    ArrayList<String> planetPopulationArrayList;
    ArrayList<String> climateArrayList;
    String found="";
    @Then("I list all names of the planets and search for planet {string}")
    public void iListAllNamesOfThePlanetsAndSearchForPlanet(String nameOfPlanet) {

        getTotalPlanets = jsPath.getInt("results.size()");
        planetsArray =new ArrayList<String>();

        for(int i=0; i<getTotalPlanets; i++){

            planetsArray.add(jsPath.get("results["+i+"].name"));
            if(nameOfPlanet.equalsIgnoreCase(planetsArray.get(i))){
                found="Planet "+planetsArray.get(i)+" found";
            }
            System.out.println(planetsArray.get(i));
        }
        System.out.println(found);
    }
    @When("I retrieve all population of those planets")
    public void iRetrieveAllPopulationOfThosePlanets() {

        planetPopulationArrayList = new ArrayList<String>();
        System.out.println("PLANET NAME\t\tPLANET POPULATION");
        for(int i=0; i<getTotalPlanets; i++){

            planetPopulationArrayList.add(jsPath.get("results["+i+"].population"));
            System.out.println(planetsArray.get(i)+"\t\t"+planetPopulationArrayList.get(i));
        }
    }

    @Then("I also retrieve all weather climates of those planets")
    public void iAlsoRetrieveAllWeatherClimatesOfThosePlanets() {

        climateArrayList = new ArrayList<String>();
        System.out.println("+++++++++++++CLIMATE++++++++++++++++");
        for(int i=0; i<getTotalPlanets; i++){

            climateArrayList.add(jsPath.get("results["+i+"].climate"));
            System.out.println(climateArrayList.get(i));
        }
    }
}
