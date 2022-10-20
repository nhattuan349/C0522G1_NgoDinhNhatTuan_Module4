package com.create_blog_application.service;

import com.create_blog_application.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);

    List<Blog> findByName(String keyword);
}
