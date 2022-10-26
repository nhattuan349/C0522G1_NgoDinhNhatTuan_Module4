package com.application_to_borrow_books.service.impl.impl;

import com.application_to_borrow_books.model.Book;
import com.application_to_borrow_books.model.Oder;
import com.application_to_borrow_books.repository.IOderRepository;
import com.application_to_borrow_books.service.impl.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OderService implements IOderService {

    @Autowired
    private IOderRepository oderRepository;


    @Override
    public Iterable<Oder> findAll() {
        return oderRepository.findAll();
    }

    @Override
    public Optional<Oder> findById(int id) {
        return oderRepository.findById(id);
    }

    @Override
    public void save(Oder oder) {
        oderRepository.save(oder);
    }

    @Override
    public void remove(int id) {
        oderRepository.deleteById(id);
    }

    @Override
    public Oder findByIdBook(Integer id) {
        return oderRepository.findById(id).orElse(null);
    }

    @Override
    public Oder findByCode(long code) {
        return oderRepository.findByCode(code);
    }

    @Override
    public Page<Oder> findAll(Pageable pageable) {
        return oderRepository.findAll(pageable);
    }

    @Override
    public Page<Oder> findByName(Pageable pageable, String code) {
        return oderRepository.findByBlogNameContaining(pageable, code);
    }
}
