package com.furama_casestudy_module_4.service.customer;


import com.furama_casestudy_module_4.model.customer.CustomerType;
import com.furama_casestudy_module_4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerTypeService extends IGeneralService<CustomerType> {

    Page<CustomerType> findAll(Pageable pageable);

    List<CustomerType> findAll();


}
