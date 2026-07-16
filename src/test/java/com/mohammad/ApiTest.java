package com.mohammad;

import files.ReUsableMethod;
import files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotEquals;

public class ApiTest {
    String baseUrl = ConfigReader.get("baseUrl");
    String customHeader = ConfigReader.get("header_value");

    @Test(priority = 1, description = "get method for /users/1")
    public void testGetRequest() {

       String  res = given()
                .baseUri(baseUrl)
                .header("x-api-key", customHeader)
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .extract()
                .response().getBody().asString();

        JsonPath js = ReUsableMethod.rawJson(res);
        String variant = js.getString("_meta.variant");
        Assert.assertEquals(variant, "v1_a");
    }

  @Test(priority = 2, description = "post method create user")
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
    int userId = js.getInt("id");
    String meta = js.getString("_meta.powered_by");
    assertNotEquals(userId, 0);
    Assert.assertEquals(meta, "ReqRes");
  }

  @Test(priority = 3, description = "get method all users")
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
  @Test(priority = 4, description = "post method login unsuccessful")
    public void PostRequest() {
        String response = given().baseUri(baseUrl).contentType("application/json").header("x-api-key", customHeader)
                .body(payload.postEmail()).when().post("/login").then().statusCode(400).extract()
                .response().asString();
        JsonPath js = ReUsableMethod.rawJson(response);
        String error = js.getString("error");
        Assert.assertEquals(error, "Missing password");
  }
}
