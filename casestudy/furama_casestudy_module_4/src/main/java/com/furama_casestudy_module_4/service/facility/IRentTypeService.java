package com.furama_casestudy_module_4.service.facility;

import com.furama_casestudy_module_4.model.facility.FacilityType;
import com.furama_casestudy_module_4.model.facility.RentType;
import com.furama_casestudy_module_4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRentTypeService extends IGeneralService<RentType> {

    Page<RentType> findAll(Pageable pageable);

    List<RentType> findAll();

}
