package com.eurotech.apiTests.day_05_POJO;

import org.testng.annotations.Test;

public class C02_BookStore_OPJO {
    @Test
    public void bookStoreGetBook_POJO_Task(){
        /**
         *
         * Given accept type json
         * When user sends a get request to https://bookstore.toolsqa.com
         * And endPoint:/BookStore/v1/Book
         * Query param ISBN = 9781449365035
         * Then status code should be 200
         * And content type should be application/json; charset=utf-8
         *          *
         * verify that isbn is 9781449365035
         * and verify that title is "Speaking JavaScript"
         * verify that author is "Axel Rauschmayer"
         * verify that publisher is "O'Reilly Media"
         * verify that pages is 460
         */
    }
}
