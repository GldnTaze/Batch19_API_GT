package com.eurotech.apiTests.day_03_JSON;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TASK {


    @BeforeClass
    public void setUpClass() {
        baseURI = "https://sdettest.eurotechstudy.eu";
    }


    @Test
    public void jsonPath_Task() {
        /**
         *  TASK
         *      Given accept type is json
         *     When user sends a GET request to /allusers/alluser
         *     query params pagesize=50, page=5
         *     Then the status Code should be 200
         *     And Content type json should be "application/json; charset=UTF-8"
         *
         *  Make following verification by using jsonPath method..
         *
         *  third user userId should be 3393
         *  third user second skill should be "Selenium"
         *  third user email should be "sld@gmail.com"
         *
         *
         *
         *  how many user does we have? it should be 22
         *
         * sixth user first education record's school should be "Bilkent"
         * sixth user first experience record's location should be "Olsonville"
         * sixth user second experience record's id should be 2609
         * sixth user id should be 3396
         */

        Response response = given().accept(ContentType.JSON)
                .queryParam("pagesize", 50)
                .queryParam("page", 56)
                .when()
                .get("sw/api/v1/allusers/alluser");

        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=UTF-8");

        JsonPath jsonPath = response.jsonPath();

        // third user userId should be 3393
        Assert.assertEquals(jsonPath.getInt("id[2]"), 3393);

        // third user second skill should be "Selenium"
        Assert.assertEquals(jsonPath.getString("skills[2][1]"), "Selenium");
        // third user email should be "sld@gmail.com"
        Assert.assertEquals(jsonPath.getString("email[2]"), "sld@gmail.com");

        // how many user does we have? it should be 22
        // Tüm user listesinin uzunluğu
        List<String> names=response.path("name");
        int userCount=names.size();
        Assert.assertEquals(userCount,23);


        // sixth user first education record's school should be "Bilkent"
        Assert.assertEquals(jsonPath.getString("education[5][0].school"), "Bilkent");


        // sixth user first experience record's location should be "Olsonville"
        Assert.assertEquals(jsonPath.getString("experience[5][0].location"), "Olsonville");


        //sixth user second experience record's id should be 2609
        Assert.assertEquals(jsonPath.getInt("experience[5][1].id"), 2609);


    }
}

