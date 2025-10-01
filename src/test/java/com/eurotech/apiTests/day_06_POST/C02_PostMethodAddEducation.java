package com.eurotech.apiTests.day_06_POST;

import com.eurotech.apiPOJOTemplates.EuroTechNewUser;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class C02_PostMethodAddEducation {
    @BeforeClass
    public void setUpClass() {
        baseURI = "https://sdettest.eurotechstudy.eu";
    }

    @Test
    public void postNewUser_withEducation() {
        /**
         * accept json
         * url:"https://sdettest.eurotechstudy.eu"
         * end point : "/sw/api/v1/allusers/register"
         * Post Method
         * provide a body any way ----> new user body (String or map or custom class (pojo))
         * Then status code should be 200
         * And content type should be application/json; charset=UTF-8
         * Assign the token to a variable because it is going to be used when we create a new education record
         *
         * new api run
         * url:"https:https://sdettest.eurotechstudy.eu
         * end point : "/sw/api/v1/education/add"
         * Post Method
         * provide token
         * provide a body ---> new education body
         * Then status code should be 200
         * And content type should be application/json; charset=UTF-8
         * assign education id  and school to variables for following verification
         *
         * new api
         * get education by id
         * endPoint :"/sw/api/v1/education/getbyid/{eduId}
         * Then status code should be 200
         * And content type should be application/json; charset=UTF-8
         * assertion with educationId and school
         *
         */

        // 1. part : create new user
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();

        EuroTechNewUser newUser=new EuroTechNewUser("Speedy Gonzales",email,"1234.Asdf","about me","10");

        Response response=given().accept(ContentType.JSON)
                .body(newUser)
                .when()
                .post("/sw/api/v1/allusers/register")
                .prettyPeek();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=UTF-8");

        String userToken=response.path("token");
        System.out.println("userToken = " + userToken);


        // 2. part : add education to newUser

        String addEducationBody= """
                {
                  "school": "Konya Tecnichal University",
                  "degree": "Masters",
                  "study": "Computer Science",
                  "fromdate": "2024-10-10",
                  "todate": "2025-10-20",
                  "current": "false",
                  "description": "Description"
                }
                """;

        response=given().accept(ContentType.JSON)
                .header("token",userToken)
                .and()
                .body(addEducationBody)
                .when()
                .post("/sw/api/v1/education/add")
                .prettyPeek();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=UTF-8");

        Assert.assertEquals(response.path("school"),"Konya Tecnichal University");

        int educationID=response.path("id");
        System.out.println("educationID = " + educationID);

        // 3. part : access newUser s education with ID

        response=given().accept(ContentType.JSON)
                .header("token",userToken)
                .and()
                .pathParam("eduId",educationID)
                .when()
                .post("/sw/api/v1/education/getbyid/{eduId}")
                .prettyPeek();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=UTF-8");

        Assert.assertEquals(response.path("degree"),"Masters");

        int actualId=response.path("id");
        String actualSchool=response.path("school");

        Assert.assertEquals(actualId,educationID);
        Assert.assertEquals(actualSchool,"Konya Tecnichal University");

    }
}
