package com.eurotech.apiTests.day_06_POST;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.eurotech.apiPOJOTemplates.EuroTechNewUser;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class C01_PostMethod_RegisterUser {
    @BeforeClass
    public void setUpClass() {
        baseURI = "https://sdettest.eurotechstudy.eu";
    }

    /**
     * Along with the others, there are 3 particular ways to provide data into the request body when we use post method:
     * 1. Assign the JSON body inside a STRING variable and put it into the body() method
     * 2. Put data inside a MAP and provide it into the body() method
     * NOTE:body() method converts the data inside the map to JSON automatically. This only happens with POST,PUT and
     * PATCH method.
     * 3. Put data into an object which is created based on a java custom class and put it into the body() method.
     */

    @Test
    public void postMethodWithString_1() {
        /**
         * //TASK
         * post method
         * baseUrl = https://sdettest.eurotechstudy.eu
         * endpoint = /sw/api/v1/allusers/register
         * Given accept type and Content type is JSON
         * And request json body is:
         {
         "name": "Speedy Gonzales",
         "email": "speedy@gonzales.com",
         "password": "1234.Asdf",
         "about": "from USA",
         "terms": "3"
         }
         * When user sends POST request
         * Then status code 200
         * And content type should be application/json; charset=UTF-8
         * And json payload/response/body should contain:
         * a new generated id that is special for user
         * verify name and email
         * verify that response body contains token
         * get the token and assign it to a variable and print it
         */


        String newUserBody="{\n" +
                "         \"name\": \"Speedy Gonzales\",\n" +
                "         \"email\": \"speedy@gonzales.com\",\n" +
                "         \"password\": \"1234.Asdf\",\n" +
                "         \"about\": \"from USA\",\n" +
                "         \"terms\": \"3\"\n" +
                "         }";

        Response response=given().accept(ContentType.JSON)  // hey api send me a body as json format
                .and()
                .contentType(ContentType.JSON)              // hey api I am sending json body
                .body(newUserBody)      // de-serialization
                .when().log().all()
                .post("/sw/api/v1/allusers/register");

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=UTF-8");

        System.out.println("**************** validations ********************");
        //         * a new generated id that is special for user
        Assert.assertNotNull(response.path("id"));
        int newuserID=response.path("id");
        System.out.println("newuserID = " + newuserID);


        //         * verify name and email
        Assert.assertEquals(response.path("email"),"speedy@gonzales.com");
        Assert.assertEquals(response.path("name"),"Speedy Gonzales");

        //         * verify that response body contains token
        Assert.assertTrue(response.body().asString().contains("token"));

        //         * get the token and assign it to a variable and print it
        String token=response.body().path("token");
        System.out.println("token = " + token);
    }

    @Test
    public void postWithString_2() {
        /**
         * //TASK
         * post method
         * baseUrl = https://sdettest.eurotechstudy.eu
         * endpoint = /sw/api/v1/allusers/register
         * Given accept type and Content type is JSON
         * And request json body is:
         {
         "name": "Speedy Gonzales",
         "email": "speedy@gonzales.com",
         "password": "1234.Asdf",
         "about": "from USA",
         "terms": "3"
         }
         * When user sends POST request
         * Then status code 200
         * And content type should be application/json; charset=UTF-8
         * And json payload/response/body should contain:
         * a new generated id that is special for user
         * verify name and email
         * verify that response body contains token
         * get the token and assign it to a variable and print it
         */
        Faker faker=new Faker();
        String name=faker.name().fullName();
        String email=faker.internet().emailAddress();
        String password=faker.internet().password(8,16,true);

        String newUserBody= """
                {
                         "name": "%s",
                         "email": "%s",
                         "password": "%s"
                         }
                """.formatted(name,email,password);

        Response response=given().accept(ContentType.JSON)  // hey api send me a body as json format
                .and()
                .contentType(ContentType.JSON)              // hey api I am sending json body
                .body(newUserBody)      // de-serialization
                .when().log().all()
                .post("/sw/api/v1/allusers/register");

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=UTF-8");

        System.out.println("**************** validations ********************");
        //         * a new generated id that is special for user
        Assert.assertNotNull(response.path("id"));
        int newuserID=response.path("id");
        System.out.println("newuserID = " + newuserID);


        //         * verify name and email
        Assert.assertEquals(response.path("email"),email);
        Assert.assertEquals(response.path("name"),name);

        //         * verify that response body contains token
        Assert.assertTrue(response.body().asString().contains("token"));

        //         * get the token and assign it to a variable and print it
        String token=response.body().path("token");
        System.out.println("token = " + token);

    }

    @Test
    public void postWithMap() {
        /**
         * {
         *          "name": "Speedy Gonzales",
         *          "email": "speedy@gonzales.com",
         *          "password": "1234.Asdf",
         *          "about": "from USA",
         *          "terms": "3"
         *          }
         */
        Faker faker=new Faker();
        String name=faker.name().fullName();
        String email=faker.internet().emailAddress();
        String password=faker.internet().password(8,16,true);

        Map<String,Object> newUserBody=new LinkedHashMap<>();
        newUserBody.put("name",name);
        newUserBody.put("email",email);
        newUserBody.put("password",password);
        newUserBody.put("about","About something");
        newUserBody.put("terms","10");

        System.out.println("newUserBody = " + newUserBody);


        Response response=given().accept(ContentType.JSON)  // hey api send me a body as json format
                .and()
                .contentType(ContentType.JSON)              // hey api I am sending json body
                .body(newUserBody)      // de-serialization
                .when().log().all()
                .post("/sw/api/v1/allusers/register");

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=UTF-8");

        System.out.println("**************** validations ********************");
        //         * a new generated id that is special for user
        Assert.assertNotNull(response.path("id"));
        int newuserID=response.path("id");
        System.out.println("newuserID = " + newuserID);


        //         * verify name and email
        Assert.assertEquals(response.path("email"),email);
        Assert.assertEquals(response.path("name"),name);

        //         * verify that response body contains token
        Assert.assertTrue(response.body().asString().contains("token"));

        //         * get the token and assign it to a variable and print it
        String token=response.body().path("token");
        System.out.println("token = " + token);

    }

    @Test
    public void postWithCustomClass() {
        Faker faker=new Faker();
        String name=faker.name().fullName();
        String email=faker.internet().emailAddress();
        String password=faker.internet().password(8,16,true);



        EuroTechNewUser newUser=new EuroTechNewUser();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);


        Response response=given().accept(ContentType.JSON)  // hey api send me a body as json format
                .and()
                .contentType(ContentType.JSON)              // hey api I am sending json body
                .body(newUser)      // de-serialization
                .when().log().all()
                .post("/sw/api/v1/allusers/register");

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=UTF-8");

        System.out.println("**************** validations ********************");
        //         * a new generated id that is special for user
        Assert.assertNotNull(response.path("id"));
        int newuserID=response.path("id");
        System.out.println("newuserID = " + newuserID);


        //         * verify name and email
        Assert.assertEquals(response.path("email"),email);
        Assert.assertEquals(response.path("name"),name);

        //         * verify that response body contains token
        Assert.assertTrue(response.body().asString().contains("token"));

        //         * get the token and assign it to a variable and print it
        String token=response.body().path("token");
        System.out.println("token = " + token);
    }

    @Test
    public void postWithCustomClass_parameters() {
        Faker faker=new Faker();
        String name=faker.name().fullName();
        String email=faker.internet().emailAddress();
        String password=faker.internet().password(8,16,true);


        // constructor with parameters
        EuroTechNewUser newUser=new EuroTechNewUser(name,email,password,"Its all about me","20");


        Response response=given().accept(ContentType.JSON)  // hey api send me a body as json format
                .and()
                .contentType(ContentType.JSON)              // hey api I am sending json body
                .body(newUser)      // de-serialization
                .when().log().all()
                .post("/sw/api/v1/allusers/register");

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=UTF-8");

        System.out.println("**************** validations ********************");
        //         * a new generated id that is special for user
        Assert.assertNotNull(response.path("id"));
        int newuserID=response.path("id");
        System.out.println("newuserID = " + newuserID);


        //         * verify name and email
        Assert.assertEquals(response.path("email"),email);
        Assert.assertEquals(response.path("name"),name);

        //         * verify that response body contains token
        Assert.assertTrue(response.body().asString().contains("token"));

        //         * get the token and assign it to a variable and print it
        String token=response.body().path("token");
        System.out.println("token = " + token);

    }

}
