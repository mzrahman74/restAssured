package com.mohammad;

import files.ReUsableMethod;
import files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import static io.restassured.RestAssured.given;

public class ApiTest {
    String baseUrl = ConfigReader.get("baseUrl");
    String customHeader = ConfigReader.get("header_value");

    @Test(priority = 1)
    public void testGetRequest() {

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

  @Test(priority = 2)
  public void testPostRequest() {
    String res =
        given()
            .baseUri(baseUrl)
            .contentType("application/json")
            .header("x-api-key", customHeader)
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

  @Test(priority = 3)
  public void GetRequest() {
    String response =
        given()
            .baseUri(baseUrl)
            .header("x-api-key", customHeader)
            .when()
            .get("/users")
            .then()
            .statusCode(200)
            .extract()
            .response()
            .asString();
    JsonPath js = ReUsableMethod.rawJson(response);
    int total = js.getInt("total");
    String email = js.getString("data[4].email");
    Assert.assertEquals(total, 12);
    Assert.assertEquals(email, "charles.morris@reqres.in");
  }
}
