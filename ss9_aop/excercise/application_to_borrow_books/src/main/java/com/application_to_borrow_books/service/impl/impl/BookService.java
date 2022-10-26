package com.application_to_borrow_books.service.impl.impl;

import com.application_to_borrow_books.model.Book;
import com.application_to_borrow_books.repository.IBookRepository;
import com.application_to_borrow_books.service.impl.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;


    @Override
    public Book findByIdBook(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book findByCode(long code) {
        return bookRepository.findByCode(code);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> findByName(Pageable pageable, String name) {
        return bookRepository.findByBlogNameContaining(pageable, name);
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(int id) {
        bookRepository.deleteById(id);
    }
}
