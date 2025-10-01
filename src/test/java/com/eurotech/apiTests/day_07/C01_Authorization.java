package com.eurotech.apiTests.day_07;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class C01_Authorization {
    @BeforeClass
    public void setUpClass() {
        baseURI = "https://sdettest.eurotechstudy.eu";
    }
    @Test
    public void  loginWithUser(){

        String email="rosa@test.com";
        String password="Test123456";

        Response response= given().accept(ContentType.MULTIPART)
                .formParam("email",email)
                .formParam("password",password)
                .when()
                .post("/sw/api/v1/allusers/login");
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertTrue(response.body().asString().contains("token"));
        Object token=response.path("token");
        System.out.println("token = " + token);
    }


}
