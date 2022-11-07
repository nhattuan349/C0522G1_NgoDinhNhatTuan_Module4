package com.furama_casestudy_module_4.service.user;


import com.furama_casestudy_module_4.model.user.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);
}
