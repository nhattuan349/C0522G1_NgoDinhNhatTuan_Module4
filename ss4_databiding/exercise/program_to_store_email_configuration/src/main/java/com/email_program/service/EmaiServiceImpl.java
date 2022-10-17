package com.email_program.service;

import com.email_program.model.Email;
import com.email_program.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmaiServiceImpl implements IEmailService{
    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public List<String> language() {
        return emailRepository.language();
    }

    @Override
    public List<Integer> pageSize() {
        return emailRepository.pageSize();
    }

    @Override
    public List<String> spamsFilter() {
        return emailRepository.spamsFilter();
    }

}
