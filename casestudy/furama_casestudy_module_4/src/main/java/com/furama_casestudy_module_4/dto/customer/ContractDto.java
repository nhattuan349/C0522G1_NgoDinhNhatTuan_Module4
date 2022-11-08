package com.furama_casestudy_module_4.dto.customer;

import com.furama_casestudy_module_4.model.customer.Customer;
import com.furama_casestudy_module_4.model.employee.Employee;
import com.furama_casestudy_module_4.model.facility.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContractDto implements Validator {
    private Integer id;
    private String startDate;
    private String endDate;
    private Double deposit;
    private Integer status;
    private Employee employee;
    private Customer customer;
    private Facility facility;

    public ContractDto() {
    }

    public ContractDto(Integer id, String startDate, String endDate,
                       Double deposit, Integer status, Employee employee,
                       Customer customer, Facility facility) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.status = status;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;



    }
}
