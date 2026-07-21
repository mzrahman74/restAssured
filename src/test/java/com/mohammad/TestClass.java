package com.mohammad;

import files.payload;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.testng.annotations.Test;
import utils.LoggerUtil;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;


public class TestClass {
  private static final Logger log =
          LoggerUtil.getLogger(TestClass.class);
  public static void main(String[] args) {

    String response =
        given().log().all()
            .baseUri("https://jsonplaceholder.typicode.com/")
            .header("Content-type", "application/json")
            .when()
            .get("posts/1")
            .then().log().all()
            .assertThat()
            .statusCode(200)
            .extract()
            .response()
            .asString();
   // System.out.println(response);
    JsonPath js = new JsonPath(response);
    String title = js.getString("title");
    String id = js.getString("id");
    System.out.println(id);

  }

@Test (priority = 2)
  public static void postCall() {
    String res = given().log().all().baseUri("https://jsonplaceholder.typicode.com/").header("Content-Type", "application/json").body(payload.postJson()).
            when().post("posts").then().assertThat().statusCode(201).body("title", equalTo("Computer"), "body", equalTo("IT")).extract().response().asString();

    JsonPath js = new JsonPath(res);
    int id = js.getInt("id");
    System.out.println(id);
  }
    }