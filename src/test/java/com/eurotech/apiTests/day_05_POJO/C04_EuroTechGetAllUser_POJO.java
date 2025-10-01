//package com.eurotech.apiTests.day_05_POJO;
//
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import static io.restassured.RestAssured.*;
//
//public class C04_EuroTechGetAllUser_POJO {
//    @BeforeClass
//    public void setUp(){
//        baseURI = "https://sdettest.eurotechstudy.eu";
//    }
//
//    @Test
//    public void pojoTest(){
//        /**
//         * Class Task
//         * Given accept type JSON
//         * and Query parameter value pagesize 10
//         * and Query parameter value page 1
//         * When user send GET request to /sw/api/v1/allusers/alluser
//         * Then response status code is 200
//         * content-type: application/json; charset=UTF-8
//         */
//
//        Response response = given()
//                .accept(ContentType.JSON)
//                .queryParam("pagesize", 10)
//                .queryParam("page", 1)
//                .when()
//                .get("/sw/api/v1/allusers/alluser");
//
//        Assert.assertEquals(response.getStatusCode(), 200);
//        Assert.assertEquals(response.contentType(), "application/json; charset=UTF-8");
//
//        //  response.prettyPrint();
//
//        EuroTechAllUser[] allUsers = response.body().as(EuroTechAllUser[].class);
//
//        System.out.println("allUsers[0].getName() = " + allUsers[0].getName());
//        System.out.println("allUsers[1].getName() = " + allUsers[1].getName());
//
//        //10th user first education school name
//        String school = allUsers[9].getEducation().get(0).getSchool();
//        System.out.println("school = " + school);
//
//        //6. user'ın bütün educationlarını alalım
//        List<Education> education = allUsers[5].getEducation();
//        System.out.println("education = " + education);
//    }
//}
