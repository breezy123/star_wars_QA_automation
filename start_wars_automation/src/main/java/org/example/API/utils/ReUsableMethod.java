package org.example.API.utils;

import io.restassured.path.json.JsonPath;

public class ReUsableMethod {
    public static JsonPath rawToJson(String response){
        return new JsonPath(response);
    }
}
