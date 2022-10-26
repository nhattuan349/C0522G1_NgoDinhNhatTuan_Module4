package com.create_blog_application.service;

import com.create_blog_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService extends IGeneralService<Category> {

    Page<Category> findAll(Pageable pageable);

    Page<Category> findByName(Pageable pageable, String name );

}
