package com.furama_casestudy_module_4.dto;

import com.furama_casestudy_module_4.model.contract.AttachFacility;
import com.furama_casestudy_module_4.model.contract.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContractDetailDto implements Validator {

    private Integer id;
    private Integer quanlity;
    private Integer status;
    private Contract contract;
    private AttachFacility attachFacility;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Integer id, Integer quanlity, Integer status,
                             Contract contract, AttachFacility attachFacility) {
        this.id = id;
        this.quanlity = quanlity;
        this.status = status;
        this.contract = contract;
        this.attachFacility = attachFacility;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(Integer quanlity) {
        this.quanlity = quanlity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDetailDto contractDto = (ContractDetailDto) target;
    }
}
