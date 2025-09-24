package com.eurotech.apiTests.day_02;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class C01_GetRequerstWithPathParam {

    //  String baseURL = "https://sdettest.eurotechstudy.eu";

    @BeforeClass
    public void setUpClass(){
        baseURI = "https://sdettest.eurotechstudy.eu";
    }

    @Test
    public void getMethodWithPathParam(){
        /**
         *  given accept type is json
         *  And path param id is 62
         *  When user send GET request to url: "https://sdettest.eurotechstudy.eu"
         *  When user send GET request to endpoint: "/sw/api/v1/allusers/getbyid/62"
         *  Then status code should be 200
         *  And content type should be "application/json; charset=UTF-8"
         *  And response body should contains "Selim Gezer"
         *
         */

        Response response = given()
                .accept(ContentType.JSON)  //assert kismini kaldirdim importu* yaptim static
                .when()
                .get("/sw/api/v1/allusers/getbyid/62"); //baseURL beforclastan

        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json; charset=UTF-8");

        assertTrue(response.body().asString().contains("Selim Gezer"));
    }

    @Test
    public void getMethodWithPathParam_2(){
        /**
         *  given accept type is json
         *  And path param id is 62
         *  When user send GET request to url: "https://sdettest.eurotechstudy.eu"
         *  When user send GET request to endpoint: "/sw/api/v1/allusers/getbyid/{userID}"
         *  Then status code should be 200
         *  And content type should be "application/json; charset=UTF-8"
         *  And response body should contains "Selim Gezer"
         *
         */

        Response response = given()
                .accept(ContentType.JSON)  //RestAssured KULLAnmadim importtan dolayi gore
                .pathParam("userID",62)
                .when()
                .get("/sw/api/v1/allusers/getbyid/{userID}");

        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json; charset=UTF-8");

        assertTrue(response.body().asString().contains("Selim Gezer"));
    }

    @Test
    public void getMethodWithPathParam_3(){
        /**
         *  given accept type is json
         *  And path param id is 62
         *  When user send GET request to url: "https://sdettest.eurotechstudy.eu"
         *  When user send GET request to endpoint: "/sw/api/v1/allusers/getbyid/{userID}"
         *  Then status code should be 200
         *  And content type should be "application/json; charset=UTF-8"
         *  And response body should contains "Selim Gezer"
         *
         */
        int user_id = 62;

        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("userID",user_id)
                .when()
                .get("/sw/api/v1/allusers/getbyid/{userID}");

        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json; charset=UTF-8");

        assertTrue(response.body().asString().contains("Selim Gezer"));
    }

    @Test
    public void getUserByIdNegativeTest(){
        /** negative get user test
         *  Given accept type is JSON
         *  Ans pathParam id is 55
         *  When the user sends a GET request to "/sw/api/v1/allusers/getbyid/{userId}"
         *  Then status code should be 404
         *  And content-type is "application/json; charset=UTF-8"
         *  And "No User Record Found..." message should be in response payload
         * */

        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("userID",55)
                .when()
                .get("/sw/api/v1/allusers/getbyid/{userID}");

        assertEquals(response.statusCode(), 404);
        assertEquals(response.contentType(), "application/json; charset=UTF-8");

        assertTrue(response.body().asString().contains("No User Record Found..."));
    }


}
