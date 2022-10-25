package com.create_blog_application.service;

import com.create_blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {

    Page<Blog> findAll(Pageable pageable);

    List<Blog> findByName(String keyword);

    Page<Blog> findByName(Pageable pageable, String keyword );
}
