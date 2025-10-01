package com.eurotech.apiTests.day_05_POJO;

import com.eurotech.apiPOJOTemplates.bookCART.BookCart_BookTemplate;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C01_bookCart_Pojo {
    @Test
    public void simplePojoTest(){


/**
 * Given accept type json
 * When user sends a get request to https://bookcart.azurewebsites.net
 * And endPoint:/api/Book/{bookId} ---> bookId =2
 * Then status code should be 200
 * And content type should be application/json; charset=utf-8
 *
 * verify that bookId is 2
 * and verify that title is "Harry Potter and the Chamber of Secrets"
 * verify that price is 236.00
 * verify that coverFileName is "9d8f4978-0ef8-42d0-873a-4eb583439237HP2.jpg"

 Note : Use POJO for verification of response body

 {
 "bookId": 2,
 "title": "Harry Potter and the Chamber of Secrets",
 "author": "JKR",
 "category": "Mystery",
 "price": 236.00,
 "coverFileName": "9d8f4978-0ef8-42d0-873a-4eb583439237HP2.jpg"
 }
 */
 String baseUrl=" https://bookcart.azurewebsites.net";
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("bookId", 2)
                .when()
                .get(baseUrl + "/api/Book/{bookId}");

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        response.prettyPrint();

        //de serialization yani json body --> custom java class

        BookCart_BookTemplate book = response.body().as(BookCart_BookTemplate.class);

        System.out.println("book.getAuthor() = " + book.getAuthor());

        //         *  verify that bookId is 2
        int bookId = book.getBookId();
        Assert.assertEquals(bookId, 2);

        //         *  and verify that title is "Harry Potter and the Chamber of Secrets"
        String title = book.getTitle();
        Assert.assertEquals(title, "Harry Potter and the Chamber of Secrets");

        //         *  verify that price is 236.00
        double price = book.getPrice();
        Assert.assertEquals(price, 236.00);

        //         *  verify that coverFileName is "9d8f4978-0ef8-42d0-873a-4eb583439237HP2.jpg"
        String coverFileName = book.getCoverFileName();
        Assert.assertEquals(coverFileName, "9d8f4978-0ef8-42d0-873a-4eb583439237HP2.jpg");


    }
    }



