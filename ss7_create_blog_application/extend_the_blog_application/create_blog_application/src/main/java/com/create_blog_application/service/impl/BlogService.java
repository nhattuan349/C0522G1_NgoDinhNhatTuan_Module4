package com.create_blog_application.service.impl;

import com.create_blog_application.model.Blog;
import com.create_blog_application.repository.IBlogRepository;
import com.create_blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findByName(String keyword) {
        return blogRepository.searchByName("%"+keyword+"%");
    }

    @Override
    public Page<Blog> findByName(Pageable pageable, String keyword) {
        return blogRepository.findByBlogNameContaining(pageable,"%"+ keyword+"%");
    }
}
