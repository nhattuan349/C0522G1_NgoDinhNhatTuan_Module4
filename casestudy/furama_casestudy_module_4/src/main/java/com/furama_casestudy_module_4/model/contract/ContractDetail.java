package com.furama_casestudy_module_4.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quanlity;
    private Integer status;


    @ManyToOne
    @JoinColumn( name = "contract_id", referencedColumnName = "id")
    private Contract contract;


    @ManyToOne
    @JoinColumn( name = "attachFacility_id", referencedColumnName = "id")
    private AttachFacility attachFacility;

    public ContractDetail() {
    }

    public ContractDetail(Integer id, Integer quanlity,
                          Integer status, Contract contract,
                          AttachFacility attachFacility) {
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
}
