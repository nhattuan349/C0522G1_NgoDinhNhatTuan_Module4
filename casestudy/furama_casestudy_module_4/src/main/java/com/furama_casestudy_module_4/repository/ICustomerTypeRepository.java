package com.furama_casestudy_module_4.repository;

import com.furama_casestudy_module_4.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
