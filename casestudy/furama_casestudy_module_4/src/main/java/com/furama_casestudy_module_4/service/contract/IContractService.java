package com.furama_casestudy_module_4.service.contract;

import com.furama_casestudy_module_4.dto.CustomerHavingBooking;
import com.furama_casestudy_module_4.model.contract.Contract;
import com.furama_casestudy_module_4.model.customer.Customer;
import com.furama_casestudy_module_4.model.facility.Facility;
import com.furama_casestudy_module_4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IContractService  {

    Page<Contract> findAll(Pageable pageable);

    Page<Contract> findByName(Pageable pageable, String start, String end);

    void save(Contract contract);

    void remove(int id);

    List<Contract> findAll();

    Optional<Contract> findById(int id);

//    Page<CustomerHavingBooking> findByNameInterface(Pageable pageable, String start, String end);

}
