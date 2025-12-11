package com.mohammad;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;

public class TestClass {
  public static void main(String[] args) {

    String response =
        given()
            .baseUri("https://jsonplaceholder.typicode.com/")
            .header("Content-type", "application/json")
            .when()
            .get("posts/1")
            .then()
            .assertThat()
            .statusCode(200)
            .extract()
            .response()
            .asString();

    JsonPath js = new JsonPath(response);
    String title = js.getString("title");
    System.out.println(title);
  }
    }

