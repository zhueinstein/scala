package com.learn.testing;

import java.math.BigDecimal;

/**
 * Created by zcx on 2017/9/29.
 */
public class Book {
   private String bookNo;
   private String bookName;
   private String author;
   private Long price;
   private String producer;

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Book(String bookNo, String bookName, String author, Long price, String producer) {
        this.bookNo = bookNo;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.producer = producer;
    }

    public Book() {
    }
}
