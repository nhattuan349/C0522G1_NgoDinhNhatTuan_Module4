package com.create_blog_application.repository;

import com.create_blog_application.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blog where author like:keyword", nativeQuery = true)
    List<Blog> searchByName(@Param("keyword") String keyword);
}
