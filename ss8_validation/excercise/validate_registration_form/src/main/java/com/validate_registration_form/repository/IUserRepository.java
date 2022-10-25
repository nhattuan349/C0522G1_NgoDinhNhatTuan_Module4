package com.validate_registration_form.repository;

import com.validate_registration_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value="select * from user where first_name like:keyword", nativeQuery = true)
    Page<User> findByBlogNameContaining(Pageable pageable, String keyword);
}
