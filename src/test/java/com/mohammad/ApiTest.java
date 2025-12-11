package com.mohammad;

import org.testng.annotations.Test;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;


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
                .response().toString();

        System.out.println("Response Body: " + res);
    }
}
