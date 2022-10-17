package com.email_program.repository;

import com.email_program.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<String> language();
    List<Integer> pageSize();
    List<String> spamsFilter();
}
