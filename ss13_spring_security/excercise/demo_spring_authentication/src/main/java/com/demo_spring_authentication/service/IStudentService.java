package com.demo_spring_authentication.service;

import com.demo_spring_authentication.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService extends IGeneralService<Student> {

    Page<Student> findAll(Pageable pageable);

    Page<Student> findByName(Pageable pageable, String name );

}
