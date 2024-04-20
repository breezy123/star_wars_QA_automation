package org.example.stepDefs.API;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.example.API.requestsCall.GetRequests;
import org.example.API.utils.ReUsableMethod;
import org.testng.Assert;

public class MovieDetails_StepDef {
    GetRequests getRequests = new GetRequests();
    public static JsonPath jsPath;
    int valueToInt;
    String filmTitles="";
    String directorName="";
    String producerName="";
    @Given("that I set the base URL {string} for API")
    public void thatISetTheBaseURLForAPI(String baseURL) {
        getRequests.setBaseURL(baseURL);
        getRequests.getBaseURL();
    }
    @When("I set the resource {string} for the API")
    public void iSetTheResourceForTheAPI(String resource) {
        getRequests.setResource(resource);
        jsPath=ReUsableMethod.rawToJson(getRequests.getCategory());
    }

    @Then("I list all {string} movies")
    public void iListAllMovies(String movieCount) {

        valueToInt = Integer.parseInt(movieCount);

        int getCount = jsPath.getInt("count");
        System.out.println("********* List of all Movies*********:\n");


        for(int i=0; i<valueToInt; i++){
            filmTitles=jsPath.get("results["+i+"].title");
            System.out.println(filmTitles+"\n");
        }
        Assert.assertEquals(valueToInt,getCount);
    }

    @When("I retrieve the title of the third movie {string}")
    public void iRetrieveTheTitleOfTheThirdMovie(String movieTitle) {
        System.out.println("********Third Movie******************\n");
        for(int i=0; i<valueToInt; i++){

            filmTitles=jsPath.get("results["+i+"].title");
            if(movieTitle.equalsIgnoreCase(filmTitles)){
                System.out.println(filmTitles);
                break;
            }
        }
        Assert.assertEquals(movieTitle,filmTitles);
    }

    @And("I retrieve the name of the director of the third move {string}")
    public void iRetrieveTheNameOfTheDirectorOfTheThirdMove(String nameOfDirector) {

        System.out.println("\n**********Retrieve Director of 3rd Movie******************\n");
        for(int i=0; i<valueToInt; i++){

            directorName=jsPath.get("results["+i+"].director");
            if(nameOfDirector.equalsIgnoreCase(directorName)){
                System.out.println(directorName);
                break;
            }
        }
        Assert.assertEquals(nameOfDirector,directorName);
    }

    @And("I retrieve the title of the fifth movie {string}")
    public void iRetrieveTheTitleOfTheFifthMovie(String movieTitle) {

        System.out.println("\n**********Get title of 5th Movie******************\n");
        for(int i=0; i<valueToInt; i++){

            filmTitles=jsPath.get("results["+i+"].title");
            if(movieTitle.equalsIgnoreCase(filmTitles)){
                System.out.println(filmTitles);
                break;
            }
        }
        Assert.assertEquals(movieTitle,filmTitles);
    }

    @Then("I confirm that {string} and {string} are not producers of the fifth movie")
    public void iConfirmThatAndAreNotProducersOfTheFifthMovie(String name1, String name2) {
        for(int i=0; i<valueToInt; i++){
            producerName=jsPath.get("results["+i+"].producer");
            if(i==4){
                break;
            }
        }
        Assert.assertNotEquals(name1,name2,producerName);
    }
}
