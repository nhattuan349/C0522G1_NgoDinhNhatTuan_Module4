package com.demo_spring_authentication.service;

import java.util.Optional;

public interface IGeneralService<T> {

    Iterable<T> findAll();

    Optional<T> findById(int id);

    void save(T t);

    void remove(int id);

}
