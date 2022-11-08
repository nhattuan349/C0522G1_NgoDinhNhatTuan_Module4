package com.furama_casestudy_module_4.service.employee;

import com.furama_casestudy_module_4.model.customer.CustomerType;
import com.furama_casestudy_module_4.model.employee.Employee;
import com.furama_casestudy_module_4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService extends IGeneralService<Employee> {
    Page<Employee> findAll(Pageable pageable);

    List<Employee> findAll();
}
