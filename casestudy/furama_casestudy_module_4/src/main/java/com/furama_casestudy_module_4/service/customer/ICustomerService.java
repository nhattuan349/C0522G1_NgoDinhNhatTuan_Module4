package com.furama_casestudy_module_4.service.customer;

import com.furama_casestudy_module_4.model.customer.Customer;
import com.furama_casestudy_module_4.model.customer.CustomerType;
import com.furama_casestudy_module_4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByName(Pageable pageable, String name);

    Page<Customer> findByName(Pageable pageable, String name, String email);

    Page<Customer> findByName(Pageable pageable, String name, String email, String customerType);




//    void delete(int id);

}
