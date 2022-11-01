package com.restful_integration_for_blog_application.service;

import com.restful_integration_for_blog_application.model.Blog;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {

    List<Blog> findByName(String keyword);

}
