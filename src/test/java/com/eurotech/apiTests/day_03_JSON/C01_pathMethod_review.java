package com.eurotech.apiTests.day_03_JSON;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class C01_pathMethod_review {
    String gorestURL="https://gorest.co.in";
    @Test
    public  void gorest_pathMethod(){

/**
 CT D03
 Given accept type json
 When user sends a get request to https://gorest.co.in/public/v2/users
 Then status code should be 200
 And content type should be application/json; charset=utf-8
 And the second user id should be 8145377
 And the third user name should be "Rakesh Bhattacharya PhD"
 */
        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .get(gorestURL + "/public/v2/users");
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");

        int secondId=8145361;
        int actualID =response.path("id[1]");
        Assert.assertEquals(actualID,secondId);

        //verify the third user name should be  Aayushman Kocchar
        String thirdName="Aayushman Kocchar";
        String actualName = response.path("name[2]");
        Assert.assertEquals(thirdName,actualName);

        List<String> names=response.path("name");
        int userCount=names.size();
        System.out.println("userCount = " + userCount);


    }
}
