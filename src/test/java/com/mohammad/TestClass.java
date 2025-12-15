package com.mohammad;

import files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;


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
    System.out.println(response);
    JsonPath js = new JsonPath(response);
    String title = js.getString("title");
    String id = js.getString("id");
    System.out.println(id);

  }

@Test (priority = 2)
  public static void postCall() {
    String res = given().baseUri("https://jsonplaceholder.typicode.com/").header("Content-Type", "application/json").body(payload.postJson()).
            when().post("posts").then().assertThat().statusCode(201).body("title", equalTo("Computer"), "body", equalTo("IT")).extract().response().asString();

    JsonPath js = new JsonPath(res);
    int id = js.getInt("id");
    System.out.println(id);
  }
    }