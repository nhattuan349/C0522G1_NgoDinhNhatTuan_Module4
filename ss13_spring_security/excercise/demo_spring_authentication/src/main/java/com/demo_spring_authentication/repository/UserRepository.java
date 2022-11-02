package com.demo_spring_authentication.repository;

import com.demo_spring_authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {

 User findByUsername(String name);

}
