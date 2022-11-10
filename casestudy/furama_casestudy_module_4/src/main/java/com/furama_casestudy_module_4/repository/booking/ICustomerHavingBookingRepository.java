package com.furama_casestudy_module_4.repository.booking;

import com.furama_casestudy_module_4.model.contract.Contract;
import com.furama_casestudy_module_4.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerHavingBookingRepository extends JpaRepository<Contract,Integer> {


}
