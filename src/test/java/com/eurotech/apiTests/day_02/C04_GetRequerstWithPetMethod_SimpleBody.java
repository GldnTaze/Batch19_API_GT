package com.eurotech.apiTests.day_02;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class C04_GetRequerstWithPetMethod_SimpleBody {

    @BeforeClass
    public void setUpClass(){
   baseURI="https://bookstore.toolsqa.com";
    }
    @Test
    public  void SimpleBodyWithPathMetod(){
        /**
         * {
         *     "isbn": "9781449325862",
         *     "title": "Git Pocket Guide",
         *     "subTitle": "A Working Introduction",
         *     "author": "Richard E. Silverman",
         *     "publish_date": "2020-06-04T08:48:39.000Z",
         *     "publisher": "O'Reilly Media",
         *     "pages": 234,
         *     "description": "This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp",
         *     "website": "http://chimera.labs.oreilly.com/books/1230000000561/index.html"
         * }
         */

        Response response = given()
                .accept(ContentType.JSON)
                .queryParam("ISBN", "9781449325862")
                .when().log().all()
                .get("/BookStore/v1/Book")
                .prettyPeek();
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");

        //isbn numarasini respons bady den alalim
        String isbn = response.body().path("isbn").toString();
        System.out.println("isbn = " + isbn);
        String title = response.path("title").toString();
        System.out.println("title = " + title);

        //subtitle bilgisini alalim
        String subTitle = response.path("subTitle");
        System.out.println("subTitle = " + subTitle);   //biz elimizle sitringe cevirdik objeyi

        String author = response.path("author");
        System.out.println("author = " + author);

        int  pages = response.path("pages");
        System.out.println("pages = " + pages);



    }
}
