package com.mohammad;

import files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LocationClass {
  @Test(priority = 1)
  public static void postPlace() {

    String response =
        given()
            .baseUri(ConfigReader.get("baseUri"))
            .log()
            .all()
            .queryParam("key", "qaclick123")
            .header("Content-Type", "application/json")
            .body(payload.AddPlace())
            .when()
            .post("/maps/api/place/add/json")
            .then()
            .assertThat()
            .statusCode(200)
            .body("scope", equalTo("APP"))
            .header("Server", "Apache/2.4.52 (Ubuntu)")
            .extract()
            .response()
            .asString();
    System.out.println(response);
    JsonPath js = new JsonPath(response);
    String placeId = js.getString("place_id");
    System.out.println(placeId);

    // update place
    given()
        .baseUri(ConfigReader.get("baseUri"))
        .log()
        .all()
        .queryParam("key", "qaclick123")
        .header("Content-type", "application/json")
        .body(payload.UpdatePlace(placeId))
        .when()
        .put("maps/api/place/update/json")
        .then()
        .assertThat()
        .log()
        .all()
        .statusCode(200)
        .body("msg", equalTo("Address successfully updated"));

    // get new address
    String getPlaceResponse =
        given()
            .baseUri(ConfigReader.get("baseUri"))
            .log()
            .all()
            .queryParam("key", "qaclick123")
            .queryParam("place_id", placeId)
            .when()
            .get("maps/api/place/get/json")
            .then()
            .assertThat()
            .log()
            .all()
            .statusCode(200)
            .extract()
            .response()
            .asString();

    JsonPath js1 = new JsonPath(getPlaceResponse);
    String newAddress = js1.getString("address");
    System.out.println(newAddress);
  }
}
