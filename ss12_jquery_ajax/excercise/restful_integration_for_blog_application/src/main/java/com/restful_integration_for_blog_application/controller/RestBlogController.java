package com.restful_integration_for_blog_application.controller;

import com.restful_integration_for_blog_application.dto.BlogDto;
import com.restful_integration_for_blog_application.model.Blog;
import com.restful_integration_for_blog_application.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/rest/blog/v1")
public class RestBlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getBlogList(@PageableDefault(value = 2) Pageable pageable) {
        Page<Blog> blogPage = blogService.findAll(pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (pageable.getPageNumber() > blogPage.getTotalPages()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage.getContent(), HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<Blog>> getStudentList() {
//        List<Blog> studentList = blogService.findAll();
//        if (studentList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(studentList, HttpStatus.OK);
//    }

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

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> seachName(@RequestParam String keyword) {
        return new ResponseEntity<>(blogService.findByName(keyword),HttpStatus.OK);
    }

}
