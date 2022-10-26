package com.application_to_borrow_books.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long code;
    private Date date;


    @ManyToMany(mappedBy = "list", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Book> books ;



    public Oder() {
    }

    public Oder(int id, long code, Date date) {
        this.id = id;
        this.code = code;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
