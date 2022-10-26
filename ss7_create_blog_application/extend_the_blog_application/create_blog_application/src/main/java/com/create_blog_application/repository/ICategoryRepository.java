package com.create_blog_application.repository;

import com.create_blog_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {

    @Query(value="select * from category where name like:name", nativeQuery = true)
    Page<Category> findByBlogNameContaining(Pageable pageable, String name);

}
