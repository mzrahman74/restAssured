package com.mohammad;

import files.ReUsableMethod;
import files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class ApiTest {

    @Test
    public void testGetRequest() {

        String baseUrl = ConfigReader.get("baseUrl");
        String customHeader = ConfigReader.get("header_value");

        String  res = given()
                .baseUri(baseUrl)
                .header("x-api-key", customHeader)
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .extract()
                .response().getBody().prettyPrint();

        System.out.println("Response Body: " + res);
    }

  @Test
  public void testPostRequest() {
    String res =
        given()
            .baseUri(ConfigReader.get("baseUrl"))
            .contentType("application/json")
            .header("x-api-key", ConfigReader.get("header_value"))
            .body(payload.postUser())
            .when()
            .post("/users")
            .then()
            .assertThat()
            .statusCode(201)
            .extract()
            .response()
            .asString();
    JsonPath js = ReUsableMethod.rawJson(res);
    String userId = js.getString("id");
    String meta = js.getString("_meta.powered_by");
    System.out.println(userId);
    System.out.println(meta);
  }
}
