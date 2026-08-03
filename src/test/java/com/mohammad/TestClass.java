package com.mohammad;

import files.payload;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.LoggerUtil;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;

public class TestClass {
  static String baseUrl_one = ConfigReader.get("baseUrl_one");
  private static final Logger log = LoggerUtil.getLogger(TestClass.class);

  public static void main(String[] args) {

    String response =
        given()
            .log()
            .all()
            .baseUri(baseUrl_one)
            .header("Content-type", "application/json")
            .when()
            .get("posts/1")
            .then()
            .log()
            .all()
            .assertThat()
            .statusCode(200)
            .extract()
            .response()
            .asPrettyString();

    JsonPath js = new JsonPath(response);
    String expected_title =
        "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
    String title = js.getString("title");
    int id = js.getInt("id");
    Assert.assertEquals(id, 1);
    Assert.assertEquals(title, expected_title);
  }

  @Test(priority = 2, description = "create post")
  public static void postCall() {
    String res =
        given()
            .log()
            .all()
            .baseUri(baseUrl_one)
            .header("Content-Type", "application/json")
            .body(payload.postJson())
            .when()
            .post("posts")
            .then()
            .assertThat()
            .statusCode(201)
            .body("title", equalTo("Computer"), "body", equalTo("IT"))
            .extract()
            .response()
            .asString();

    JsonPath js = new JsonPath(res);
    int id = js.getInt("id");
    int userId = js.getInt("userId");
    Assert.assertEquals(id, 101);
    Assert.assertEquals(userId, 200);
  }

  @Test(priority = 3, description = "put call for posts/2")
  public static void putCall() {
    String response =
        given().log().headers()
            .baseUri(baseUrl_one)
            .contentType("application/json")
            .body(payload.putBody())
            .when()
            .put("/posts/2")
            .then()
            .statusCode(200)
            .extract()
            .response()
            .asString();

    JsonPath js = new JsonPath(response);
    String body = js.getString("body");
    Assert.assertEquals(body, "New post");
  }
}
