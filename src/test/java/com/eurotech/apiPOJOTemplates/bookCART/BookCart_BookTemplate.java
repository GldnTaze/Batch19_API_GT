package com.eurotech.apiPOJOTemplates.bookCART;

public class BookCart_BookTemplate {


 /*
    {
    "bookId": 2,
    "title": "Harry Potter and the Chamber of Secrets",
    "author": "JKR",
    "category": "Mystery",
    "price": 236.00,
    "coverFileName": "9d8f4978-0ef8-42d0-873a-4eb583439237HP2.jpg"
}

     */

    private int bookId;
    private String title;
    private String author;
    private String category;
    private double price;
    private String coverFileName;

    public BookCart_BookTemplate() {
    }

    public BookCart_BookTemplate(int bookId, String title, String author, String category, double price, String coverFileName) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.coverFileName = coverFileName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCoverFileName() {
        return coverFileName;
    }

    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }

    @Override
    public String toString() {
        return "BookCart_BookTemplate{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", coverFileName='" + coverFileName + '\'' +
                '}';
    }

}
