package com.furama_casestudy_module_4.service.facility;

import com.furama_casestudy_module_4.model.customer.CustomerType;
import com.furama_casestudy_module_4.model.facility.FacilityType;
import com.furama_casestudy_module_4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityTypeService extends IGeneralService<FacilityType> {

    Page<FacilityType> findAll(Pageable pageable);

    List<FacilityType> findAll();
}
