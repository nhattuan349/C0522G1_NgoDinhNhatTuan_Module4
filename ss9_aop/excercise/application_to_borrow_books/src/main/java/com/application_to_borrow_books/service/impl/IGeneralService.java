package com.application_to_borrow_books.service.impl;

import java.util.Optional;

public interface IGeneralService<T>{

    Iterable<T> findAll();

    Optional<T> findById(int id);

    void save(T t);

    void remove(int id);

}
