package com.validate_registration_form.service;

import com.validate_registration_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends IGeneralService<User>{
    Page<User> findAll(Pageable pageable);

    Page<User> findByName(Pageable pageable, String keyword );
}
