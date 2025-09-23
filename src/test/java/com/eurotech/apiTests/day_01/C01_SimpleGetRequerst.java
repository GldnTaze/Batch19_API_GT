package com.eurotech.apiTests.day_01;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_SimpleGetRequerst {
    String bookStoreBaseURL = "https://bookstore.toolsqa.com";
    String petStore="https://petstore.swagger.io/v2";

    @Test
    public void basicGetRequest(){
        /**
         *  When user send GET request to url: "https://bookstore.toolsqa.com"
         *  When user send GET request to endpoint: "/BookStore/v1/Books"
         *  Print response status code
         *  Print whole json body (response)
         *
         *  firstly control request and response data from swagger or postman
         */

        Response response = RestAssured.get("https://bookstore.toolsqa.com/BookStore/v1/Books");

        System.out.println("response.statusCode() = " + response.statusCode());

        response.prettyPrint();

    }

    @Test
    public void basicGetRequest_2(){
        /**
         *  When user send GET request to url: "https://bookstore.toolsqa.com"
         *  When user send GET request to endpoint: "/BookStore/v1/Books"
         *  Make base url global variable
         *  Print response status code
         *  Print whole json body
         *
         *  firstly control request and response data from swagger or postman
         */

        Response response = RestAssured.get(bookStoreBaseURL + "/BookStore/v1/Books");

        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        response.prettyPrint();
    }

    @Test
    public void basicGetRequestWithHeaders(){
        /**
         *  When user send GET request to url: "https://bookstore.toolsqa.com"
         *  When user send GET request to endpoint: "/BookStore/v1/Books"
         *  Given accept type is JSON
         *  Then verify that response status code 200
         *  and body is JSON format ("application/json; charset=utf-8")
         *
         *  firstly control request and response data from swagger or postman
         */

        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get(bookStoreBaseURL + "/BookStore/v1/Books");

        //verification
        //status code'u assert edelim..
        Assert.assertEquals(response.statusCode(), 200);

        //response content-type'ını assert edelim..
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

    }
    @Test
    public void basicGetRequestWithHeaders_Task(){
        /**
         *  When user send GET request to url: "https://petstore.swagger.io/v2"
         *  When user send GET request to endpoint: "/store/inventory"
         *  Given accept type is JSON
         *  Then verify that response status code 200
         *  and body is JSON format ("application/json")
         *  firstly control request and response data from swagger or postman
         */
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get(petStore + "/store/inventory");
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json");
    }


    @Test
    public void getRequestVerificationWithRestAssured(){
        /** Verify test case by using RestAssured Library
         *
         *  When user send GET request to url: "https://bookstore.toolsqa.com"
         *  When user send GET request to endpoint: "/BookStore/v1/Books"
         *  Given accept type is JSON
         *  Then verify that response status code 200
         *  and body is JSON format (application/json; charset=utf-8)
         *
         *  firstly control request and response data from swagger or postman
         */

        ValidatableResponse validatableResponse = RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get(bookStoreBaseURL + "/BookStore/v1/Books")
                .then()
                .assertThat()
                .statusCode(200) // assertion
                .and()
                .contentType("application/json; charset=utf-8"); //assertion

        //ek bilgi olarak eklenmiştir.
        validatableResponse.statusCode(200); // validatable responsu bir daha assert ettiğimiz yer.
        validatableResponse.contentType("application/json; charset=utf-8");
    }

    @Test
    public void getRequestVerificationWithRestAssured_Task(){
        /** Verify test case by using RestAssured Library
         *  When user send GET request to url: "https://petstore.swagger.io/v2"
         *  When user send GET request to endpoint: "/store/inventory"
         *  Given accept type is JSON
         *  Then verify that response status code 200
         *  and body is JSON format ("application/json")
         *  firstly control request and response data from swagger or postman
         */
        RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get(petStore+"/store/inventory")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json");
    }

    @Test
    public void validateResponseBodyWithContainsMethod(){
        /**
         *  When user send GET request to url: "https://bookstore.toolsqa.com"
         *  When user send GET request to endpoint: "/BookStore/v1/Books"
         *  Given accept type is JSON
         *  Then verify that response status code 200
         *  and body is JSON format (application/json; charset=utf-8)
         *  and json body contains "Axel Rauschmayer" as an author
         *
         *  firstly control request and response data from swagger or postman
         */

        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get(bookStoreBaseURL + "/BookStore/v1/Books");

        //verification
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

        //body verification
        String wholeBody = response.body().asString();
        String wholeBody2 = response.asString();

        Assert.assertTrue(wholeBody.contains("Axel Rauschmayer"));
        Assert.assertTrue(wholeBody2.contains("Axel Rauschmayer"));
    }

    @Test
    public void validateResponseBodyWithContainsMethod_Task(){
        /**
         *  When user send GET request to url: "https://petstore.swagger.io/v2"
         *  When user send GET request to endpoint: "/store/inventory"
         *  Given accept type is JSON
         *  Then verify that response status code 200
         *  and body is JSON format ("application/json")
         *  and json body contains "available" as category
         *  firstly control request and response data from swagger or postman
         */
        Response response = RestAssured.given()
                .accept(ContentType.JSON)
                .when()
                .get(petStore + "/store/inventory");
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json");

        String Body = response.body().asString();
        Assert.assertTrue(Body.contains("available"));

    }
}
