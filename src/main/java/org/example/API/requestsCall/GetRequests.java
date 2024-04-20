package org.example.API.requestsCall;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import lombok.Getter;
import lombok.Setter;
import org.example.API.utils.ReUsableMethod;

import static io.restassured.RestAssured.given;

public class GetRequests {

    private  String baseURL;
    @Setter
    @Getter
    private String resource;
    public void setBaseURL(String baseURL){
        this.baseURL=baseURL;
    }

    public String getBaseURL(){
        return RestAssured.baseURI=this.baseURL;
    }

    public String getCategory(){
        String getAPIdata = given().log().all()
                .when().get(getResource())
                .then().assertThat().log().all().statusCode(200).extract().response().asString();
        return getAPIdata;
    }
}
