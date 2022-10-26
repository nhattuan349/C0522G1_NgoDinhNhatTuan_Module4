package com.application_to_borrow_books.service.impl;

import com.application_to_borrow_books.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBookService extends IGeneralService<Book> {

    Book findByIdBook(Integer id);

    Book findByCode(long code);

    Page<Book> findAll(Pageable pageable);

    Page<Book> findByName(Pageable pageable, String name );
}
