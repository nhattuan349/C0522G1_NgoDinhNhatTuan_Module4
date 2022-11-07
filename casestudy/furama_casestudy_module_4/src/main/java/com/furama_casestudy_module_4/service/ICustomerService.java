package com.furama_casestudy_module_4.service;

import com.furama_casestudy_module_4.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByName(Pageable pageable, String name);

    Page<Customer> findByName(Pageable pageable, String name, String email);

    Page<Customer> findByStatus(String status, Pageable pageable);

    Page<Customer> findByNameAndEmail(String name, String email, String status, Pageable pageable);

    Page<Customer> findByNameEmailAndCustomerTypeId(String name, String email, String status, String customerTypeId, Pageable pageable);

//    void delete(int id);

}
