package com.restful_integration_for_blog_application.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {

    List<T> findAll();

    Optional<T> findById(int id);

    T save(T t);

    void remove(int id);

}
