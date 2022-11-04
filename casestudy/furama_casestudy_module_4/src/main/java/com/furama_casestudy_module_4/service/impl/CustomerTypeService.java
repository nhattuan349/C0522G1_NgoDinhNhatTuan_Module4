package com.furama_casestudy_module_4.service.impl;

import com.furama_casestudy_module_4.model.customer.Customer;
import com.furama_casestudy_module_4.model.customer.CustomerType;
import com.furama_casestudy_module_4.repository.ICustomerRepository;
import com.furama_casestudy_module_4.repository.ICustomerTypeRepository;
import com.furama_casestudy_module_4.service.ICustomerService;
import com.furama_casestudy_module_4.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;


    @Override
    public Page<CustomerType> findAll(Pageable pageable) {
        return customerTypeRepository.findAll(pageable);
    }

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Optional<CustomerType> findById(int id) {
        return customerTypeRepository.findById(id);
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }

    @Override
    public void remove(int id) {
        customerTypeRepository.deleteById(id);
    }
}
