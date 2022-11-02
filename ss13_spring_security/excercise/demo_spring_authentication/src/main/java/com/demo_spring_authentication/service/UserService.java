package com.demo_spring_authentication.service;

import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

}
