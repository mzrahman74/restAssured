package com.mohammad;

import files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Location {
    @Test
    public void addPlace() {
    String response = given().baseUri("https://rahulshettyacademy.com/").queryParam("key", "qaclick123").header("Content-Type", "application/json").body(payload.AddPlace())
            .when().post("maps/api/place/add/Json").then().log().all().assertThat().statusCode(200).extract().toString();
        System.out.println("location" + response);

        JsonPath js = new JsonPath(response);

       String placeId = js.get("scope");
        System.out.println(placeId);
    }
}
