package com.demo_spring_authentication.repository;

import com.demo_spring_authentication.model.Student;
import com.demo_spring_authentication.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    @Query(value="select * from student where name like:name", nativeQuery = true)
    Page<Student> findByStudentNameContaining(Pageable pageable, String name);

}
