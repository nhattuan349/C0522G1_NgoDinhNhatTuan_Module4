package com.restful_integration_for_blog_application.repository;

import com.restful_integration_for_blog_application.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
