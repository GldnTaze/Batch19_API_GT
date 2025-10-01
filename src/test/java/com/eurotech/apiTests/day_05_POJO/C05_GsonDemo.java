package com.eurotech.apiTests.day_05_POJO;

import com.eurotech.apiPOJOTemplates.bookCART.BookCart_BookTemplate;
import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class C05_GsonDemo {
    @Test
    public void deSerialization(){
        /**
         * bookCart book body
         {
         "bookId": 2,
         "title": "HP2",
         "author": "JKR",
         "category": "Mystery",
         "price": 235.00,
         "coverFileName": "9d8f4978-0ef8-42d0-873a-4eb583439237HP2.jpg"
         }
         */

        //dönüştürücü Gson

        Gson gson = new Gson();

        String jsonBody = "{\n" +
                "         \"bookId\": 2,\n" +
                "         \"title\": \"HP2\",\n" +
                "         \"author\": \"JKR\",\n" +
                "         \"category\": \"Mystery\",\n" +
                "         \"price\": 235.00,\n" +
                "         \"coverFileName\": \"9d8f4978-0ef8-42d0-873a-4eb583439237HP2.jpg\"\n" +
                "         }";

        System.out.println("jsonBody = " + jsonBody);
        System.out.println("----------------");

        //de-serialization json --> map
        Map<String ,Object> mapBody = gson.fromJson(jsonBody, Map.class);

        System.out.println("mapBody = " + mapBody);

        //de-serialization json --> custom class (pojo)
        BookCart_BookTemplate bookCartBook = gson.fromJson(jsonBody, BookCart_BookTemplate.class);
        System.out.println("bookCartBook.getCategory() = " + bookCartBook.getCategory());


    }

    @Test
    public void deSerialization_2(){
        /**
         * bookCart book body
         {
         "bookId": 2,
         "title": "HP2",
         "author": "JKR",
         "category": "Mystery",
         "price": 235.00,
         "coverFileName": "9d8f4978-0ef8-42d0-873a-4eb583439237HP2.jpg"
         }
         */

        //dönüştürücü Gson

        Gson gson = new Gson();

        String jsonBody = """
                {
                         "bookId": 2,
                         "title": "HP2",
                         "author": "JKR",
                         "category": "Mystery",
                         "price": 235.00,
                         "coverFileName": "9d8f4978-0ef8-42d0-873a-4eb583439237HP2.jpg"
                         }
                """;

        System.out.println("jsonBody = " + jsonBody);
        System.out.println("----------------");

        //de-serialization json --> map
        Map<String ,Object> mapBody = gson.fromJson(jsonBody, Map.class);

        System.out.println("mapBody = " + mapBody);

        //de-serialization json --> custom class (pojo)
        BookCart_BookTemplate bookCartBook = gson.fromJson(jsonBody, BookCart_BookTemplate.class);
        System.out.println("bookCartBook.getCategory() = " + bookCartBook.getCategory());
        System.out.println("bookCartBook.getTitle() = " + bookCartBook.getTitle());

    }

    @Test
    public void serialization(){
        //custom java class to json object
        BookCart_BookTemplate bookCartBook =
                new BookCart_BookTemplate(25,"Kara Kitap","Orhan Pamuk","Realist",255.25,"zzz.jpg");

        System.out.println("bookCartBook = " + bookCartBook);

        //dönüştürmek için gson objemizi olışturalım
        Gson gson = new Gson();

        //java objesini dönüştürücü ile json objesine çevirelim
        String json = gson.toJson(bookCartBook);

        System.out.println("json = " + json);

        BookCart_BookTemplate bookCartBook1 =
                new BookCart_BookTemplate();
        bookCartBook1.setBookId(251);
        bookCartBook1.setTitle("Karamazof Kardeşler");
        bookCartBook1.setAuthor("Dostoyevski");
        bookCartBook1.setCategory("Novel");
        bookCartBook1.setPrice(295.00);
        bookCartBook1.setCoverFileName("ddd.bmp");

        String json1 = gson.toJson(bookCartBook1);
        System.out.println("json1 = " + json1);

    }

    @Test
    public void javaMapToJson(){
        // serialization  java map --> json file

        /**
         * id = 66
         * name = Serap
         * email = serap@gmail.com
         */

        Map<String , Object> mapData = new HashMap<>();
        mapData.put("id",66);
        mapData.put("name","Serap");
        mapData.put("email","serap@gmail.com");

        System.out.println("mapData = " + mapData);

        Gson gson = new Gson();
        String jsonData = gson.toJson(mapData);
        System.out.println("jsonData = " + jsonData);
    }
}
