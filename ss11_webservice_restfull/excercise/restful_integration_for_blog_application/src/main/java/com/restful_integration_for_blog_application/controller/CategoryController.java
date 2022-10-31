package com.restful_integration_for_blog_application.controller;

import com.restful_integration_for_blog_application.dto.BlogDto;
import com.restful_integration_for_blog_application.dto.CategoryDto;
import com.restful_integration_for_blog_application.model.Blog;
import com.restful_integration_for_blog_application.model.Category;
import com.restful_integration_for_blog_application.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category/v1")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getStudentList() {
        List<Category> studentList = categoryService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable int id,
            @RequestBody CategoryDto categoryDto
    ) {
        Optional<Category> currentCategory = categoryService.findById(id);
        if (!currentCategory.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Category category = new Category();

        categoryDto.setName(currentCategory.get().getName());

        BeanUtils.copyProperties(categoryDto, category);
        return new ResponseEntity<Category>(categoryService.save(category), HttpStatus.OK);
    }



}
