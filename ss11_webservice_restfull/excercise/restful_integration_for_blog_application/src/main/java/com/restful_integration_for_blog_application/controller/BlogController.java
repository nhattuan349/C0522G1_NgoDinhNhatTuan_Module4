package com.restful_integration_for_blog_application.controller;

import com.restful_integration_for_blog_application.dto.BlogDto;
import com.restful_integration_for_blog_application.model.Blog;
import com.restful_integration_for_blog_application.service.IBlogService;
import com.restful_integration_for_blog_application.service.impl.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog/v1")
public class BlogController {

    @Autowired
    private IBlogService blogService;


    @GetMapping
    public ResponseEntity<List<Blog>> getStudentList() {
        List<Blog> studentList = blogService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> save(@RequestBody BlogDto blogDto) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(
            @PathVariable int id,
            @RequestBody BlogDto blogDto
    ) {
        Optional<Blog> currentBlog = blogService.findById(id);
        if (!currentBlog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Blog blog = new Blog();

        blogDto.setAuthor(currentBlog.get().getAuthor());
        blogDto.setPrice(currentBlog.get().getPrice());
        blogDto.setStatus(currentBlog.get().getStatus());

        BeanUtils.copyProperties(blogDto, blog);
        return new ResponseEntity<Blog>(blogService.save(blog), HttpStatus.OK);
    }

}
