package com.restful_integration_for_blog_application.service;

import com.restful_integration_for_blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {

    List<Blog> findByName(String keyword);

    Page<Blog> findAll(Pageable pageable);
}
