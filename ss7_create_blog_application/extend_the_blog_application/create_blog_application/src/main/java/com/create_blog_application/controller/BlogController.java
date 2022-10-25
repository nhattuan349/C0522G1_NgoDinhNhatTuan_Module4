package com.create_blog_application.controller;


import com.create_blog_application.model.Blog;
import com.create_blog_application.service.IBlogService;
import com.create_blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("categoryList", categoryService.findAll());
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

//    @GetMapping("/blogs")
//    public ModelAndView listBlogs() {
//        ModelAndView modelAndView = new ModelAndView("/blog/list");
//        modelAndView.addObject("blogs", blogService.findAll());
//        return modelAndView;
//
//    }

    @GetMapping("/blogs")
    public ModelAndView listBlogs(@PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogService.findAll(pageable));
        return modelAndView;

    }

//    @GetMapping("/")
//    public String showList(@PageableDefault(value = 2) Pageable pageable,
//                           @RequestParam(defaultValue = "") String name, Model model){
//        Page<Blog> blogs= blogService.findByName(pageable , name) ;
//        model.addAttribute("names" , name);
//        model.addAttribute("blogs",blogs);
//        return "blog/list";
//    }



    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:blogs";
    }

//    @GetMapping("/search")
//    public String seachName(@RequestParam String keyword, Model model) {
//        model.addAttribute("blogs",blogService.findByName(keyword));
//        return "blog/list";
//    }

    @GetMapping("/search")
    public String seachName(@PageableDefault Pageable pageable,
                            @RequestParam String keyword, Model model) {

        model.addAttribute("blogs",blogService.findByName(pageable, keyword));
        return "blog/list";
    }
}
