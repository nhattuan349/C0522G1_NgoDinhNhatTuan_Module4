package com.application_to_borrow_books.service.impl;

import com.application_to_borrow_books.model.Book;
import com.application_to_borrow_books.model.Oder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOderService extends IGeneralService<Oder> {

    Oder findByIdBook(Integer id);

    Oder findByCode(long code);

    Page<Oder> findAll(Pageable pageable);

    Page<Oder> findByName(Pageable pageable, String code );

}
