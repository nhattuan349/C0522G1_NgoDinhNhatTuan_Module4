package com.furama_casestudy_module_4.service.facility;

import com.furama_casestudy_module_4.model.customer.Customer;
import com.furama_casestudy_module_4.model.facility.Facility;
import com.furama_casestudy_module_4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IFacilityService extends IGeneralService<Facility> {

    Page<Facility> findAll(Pageable pageable);

    Page<Facility> findByName(Pageable pageable, String name, String facilityType);
}
