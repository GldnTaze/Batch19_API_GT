//package com.eurotech.apiTests.day_05_POJO;
//
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import static io.restassured.RestAssured.*;
//
//public class C03_EuroTech_GetUser_POJO {
//    @BeforeClass
//    public void setUp(){
//        baseURI = "https://sdettest.eurotechstudy.eu";
//    }
//
//    @Test
//    public void pojoTest(){
//        /**
//         * TASK
//         * base url = https://sdettest.eurotechstudy.eu
//         * end point /sw/api/v1/allusers/getbyid/{id}
//         * id parameter value is 62
//         * send the GET request
//         * then status code should be 200
//         * get all data into a custom class (POJO) by de-serilization
//         *
//         * verify that email is "sgezer@gmail.com"
//         * verify that id is 62
//         * verify that name is "Selim Gezer"
//         * verify that third skill is TestNG
//         * verify that second education's school record is "İTÜ"
//         * verify that first experience id is 992 and job is "Fizik Öğretmeni"
//         */
//
//        Response response = given()
//                .accept(ContentType.JSON)
//                .pathParam("id", 62)
//                .when()
//                .get("/sw/api/v1/allusers/getbyid/{id}");
//
//        Assert.assertEquals(response.getStatusCode(), 200);
//        Assert.assertEquals(response.contentType(), "application/json; charset=UTF-8");
//
//        //   response.body().prettyPrint();
//
//        apiPOJOTemplates.euroTech.EuroTechUser[] user = response.as(apiPOJOTemplates.euroTech.EuroTechUser[].class);
//
//        System.out.println("user.getId() = " + user[0].getId());
//
//        //* verify that email is "sgezer@gmail.com"
//        String email = user[0].getEmail();
//        Assert.assertEquals(email, "sgezer@gmail.com");
//        //* verify that id is 62
//        int id = user[0].getId();
//        Assert.assertEquals(id, 62);
//        //* verify that name is "Selim Gezer"
//        String name = user[0].getName();
//        Assert.assertEquals(name, "Selim Gezer");
//
//        //* verify that third skill is TestNG
//        String thirdSkill = user[0].getSkills().get(2);
//        Assert.assertEquals(thirdSkill, "TestNG");
//
//        //* verify that second education's school record is "İTÜ"
//        String school = user[0].getEducation().get(1).getSchool();
//        Assert.assertEquals(school, "İTÜ");
//
//        //* verify that first experience id is 992 and  job is "Fizik Öğretmeni"
//        int id1 = user[0].getExperience().get(0).getId();
//        Assert.assertEquals(id1,992);
//
//        String job = user[0].getExperience().get(0).getJob();
//        Assert.assertEquals(job, "Fizik Öğretmeni");
//
//    }
//}
