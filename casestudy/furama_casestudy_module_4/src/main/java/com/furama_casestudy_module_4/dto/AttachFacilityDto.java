package com.furama_casestudy_module_4.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AttachFacilityDto implements Validator {
    private Integer id;
    private String name;
    private Double cost;
    private String unit;
    private String status;
    private Integer statusDelete;

    public AttachFacilityDto() {
    }

    public AttachFacilityDto(Integer id, String name, Double cost, String unit, String status, Integer statusDelete) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.statusDelete = statusDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(Integer statusDelete) {
        this.statusDelete = statusDelete;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AttachFacilityDto attachFacilityDto = (AttachFacilityDto) target;
    }



}
