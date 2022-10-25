package com.create_blog_application.repository;

import com.create_blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blog where author like:keyword", nativeQuery = true)
    List<Blog> searchByName(@Param("keyword") String keyword);

    @Query(value="select * from blog where first_name like:keyword", nativeQuery = true)
    Page<Blog> findByBlogNameContaining(Pageable pageable, String keyword);
}
