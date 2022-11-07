package com.furama_casestudy_module_4.service.impl.customer;

import com.furama_casestudy_module_4.model.customer.Customer;
import com.furama_casestudy_module_4.repository.customer.ICustomerRepository;
import com.furama_casestudy_module_4.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByName(Pageable pageable, String name) {
        return customerRepository.findByBlogNameContaining(pageable, "%" + name + "%");
    }

    @Override
    public Page<Customer> findByName(Pageable pageable, String name, String email) {
        return customerRepository.findByCustomerNameAndEmailContaining(pageable, "%" + name + "%", "%" + email + "%");
    }

    @Override
    public Page<Customer> findByName(Pageable pageable, String name, String email, String customerType) {
        return customerRepository.findByCustomerNameEmailAndCustomerTypeContaining(pageable, "%" + name + "%", "%" + email + "%","%" + customerType + "%");
    }



//    @Override
//    public void delete(int id) {
//        customerRepository.delete(id);
//    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.delete(id);
    }


}
