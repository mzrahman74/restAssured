package com.mohammad;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    public static void main(String[] args){
    JsonPath js = new JsonPath(payload.CoursePrice());
   int count= js.getInt("courses.size()");
    System.out.println(count);
    // purchase amount
     int purchaseAmount = js.getInt("dashboard.purchaseAmount");
    System.out.println(purchaseAmount);
   String firstTitle = js.getString("courses[0].title");
    System.out.println(firstTitle);
    // print all courses title and prices
        for(int i =0; i<count; i++) {
      String courseTitles = js.get("courses["+i+"].title");
      System.out.println(courseTitles);
      System.out.println(js.get("courses["+i+"].price").toString());
        }
    }
}
