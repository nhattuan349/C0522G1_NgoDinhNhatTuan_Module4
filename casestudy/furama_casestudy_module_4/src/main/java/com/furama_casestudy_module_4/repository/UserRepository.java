package com.furama_casestudy_module_4.repository;

import com.furama_casestudy_module_4.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String name);

}
