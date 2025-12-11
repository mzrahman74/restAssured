package com.mohammad;

import files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {
    @Test(dataProvider = "BooksData")
    public void addBook(String isbn, String aisle) {

    String response =    given().baseUri("http://216.10.245.166").header("Content-type", "application/json").
                body(payload.AddBook(isbn, aisle)).when().post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();

        JsonPath js = new JsonPath(response);
        String id = js.get("ID");
        String Msg = js.get("Msg");
        System.out.println(id);
        System.out.println(Msg);


    }
    @DataProvider(name="BooksData")
    public Object[][] getData() {
        return new Object[][] {{"ppcy", "7634"}, {"uryu", "9876"}, {"ghj", "543"}};
    }
}
