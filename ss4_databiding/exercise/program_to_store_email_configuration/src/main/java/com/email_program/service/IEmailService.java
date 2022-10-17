package com.email_program.service;

import com.email_program.model.Email;

import java.util.List;

public interface IEmailService {
    List<String> language();
    List<Integer> pageSize();
    List<String> spamsFilter();
}
