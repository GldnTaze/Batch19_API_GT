package com.eurotech.apiTests.day_07;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class C02_Post_Put_Patch_Delete_experience {
    @BeforeClass
    public void setUpClass() {
        baseURI = "https://sdettest.eurotechstudy.eu";
    }

    /**
     * Class Task
     * <p>
     * prepare following flow
     * add an experience to a valid count
     * update the experience record with put
     * update the experience record with patch
     * delete the experience record
     * <p>
     * use as base url: "https://sdettest.eurotechstudy.eu"
     * add experience endPoint: "/sw/api/v1/experience/add"
     * update with put endPoint: "/sw/api/v1/experience/updateput"
     * update with patch endPoint: "/sw/api/v1/experience/updatepatch"
     * delete experience endPoint: "/sw/api/v1/experience/delete"
     * <p>
     * all request returns 200 status code if they works properly.
     * make assertion with status code
     */

   static String token;
    String email = "speedy@gonzales.com";
    String password = "1234.Asdf";
    Response response;
   static int expID;


    public String getToken() {

        response = given().accept(ContentType.MULTIPART)     // content type değişti !!!
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post("/sw/api/v1/allusers/login");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.body().asString().contains("token"));

       return token = response.path("token");

    }

    @Test (priority = 1)
    public void addExperience() {
        String addExpBody="{\n" +
                "  \"job\": \"Product Manager\",\n" +
                "  \"company\": \"SpaceX\",\n" +
                "  \"location\": \"USA\",\n" +
                "  \"fromdate\": \"2015-01-01\",\n" +
                "  \"todate\": \"2020-05-25\",\n" +
                "  \"current\": \"false\",\n" +
                "  \"description\": \"Mars 4ever\"\n" +
                "}";


        response=given().contentType(ContentType.JSON)
                .header("token",getToken())
                .body(addExpBody)
                .when()
                .post("/sw/api/v1/experience/add");

        Assert.assertEquals(response.statusCode(),200);

        int userID=3468;
        int actualID=response.path("userid");
        Assert.assertEquals(actualID,userID);

        expID=response.path("id");
        System.out.println("expID = " + expID);

    }

    @Test (priority = 2)
    public void updateExp_PUT() {

        String body= """
                {
                  "job": "DB Admin",
                  "company": "Microsoft",
                  "location": "USA",
                  "fromdate": "2023-05-26",
                  "todate": "2025-10-10",
                  "current": "false",
                  "description": "well earned"
                }
                """;

        response=given().accept(ContentType.JSON)
                .header("token",getToken())
                .queryParam("id",expID)
                .body(body)
                .when()
                .put("/sw/api/v1/experience/updateput");

        Assert.assertEquals(response.statusCode(),200);

        String expectedJob="DB Admin";
        String actualJob=response.path("job");
        Assert.assertEquals(actualJob,expectedJob);
    }

    @Test (priority = 3)
    public void updateExp_PATCH() {
        String body= """
                {
                  "company": "Google Inc",
                  "location": "USA"
                }
                """;

        Map<String,Object> mapBody=new LinkedHashMap<>();
        mapBody.put("company","Google Inc");
        mapBody.put("location", "USA");

        response=given().accept(ContentType.JSON)
                .header("token",getToken())
                .pathParam("id",expID)
            //    .body(body)
                .body(mapBody)
                .when()
                .patch("/sw/api/v1/experience/updatepatch/{id}");

        Assert.assertEquals(response.statusCode(),200);

    String expectedCompany="Google Inc";
    String actualCompany=response.path("company");
    Assert.assertEquals(actualCompany,expectedCompany);
    }

    @Test   (priority = 4)
    public void deleteExp() {
        response=given().accept(ContentType.JSON)
                .header("token",getToken())
                .pathParam("id",expID)
                .when()
                .delete("/sw/api/v1/experience/delete/{id}");

        Assert.assertEquals(response.statusCode(),200);

        String expectedMessage="Experience Deleted Successfully...";
        Assert.assertTrue(response.body().asString().contains(expectedMessage));
    }
}
