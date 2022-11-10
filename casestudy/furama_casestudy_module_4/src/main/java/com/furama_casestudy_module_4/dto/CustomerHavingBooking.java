package com.furama_casestudy_module_4.dto;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CustomerHavingBooking {

    String getCustomerName();
    String getFacilityList();
    String getEmployeeName();
    String getEndDaTe();
    String getStartDate();
    Integer getCustomerId();
}
