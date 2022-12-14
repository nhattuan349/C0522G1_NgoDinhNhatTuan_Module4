package com.furama_casestudy_module_4.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {

    Iterable<T> findAll();

    Optional<T> findById(int id);

    void save(T t);

    void remove(int id);

}
