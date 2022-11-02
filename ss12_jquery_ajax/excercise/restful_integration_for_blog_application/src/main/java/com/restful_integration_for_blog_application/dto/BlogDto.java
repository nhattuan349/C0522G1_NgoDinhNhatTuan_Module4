package com.restful_integration_for_blog_application.dto;

public class BlogDto {
    private Integer id;
    private String author;
    private Integer price;
    private String status;

    public BlogDto() {
    }

    public BlogDto(Integer id, String author, Integer price, String status) {
        this.id = id;
        this.author = author;
        this.price = price;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
