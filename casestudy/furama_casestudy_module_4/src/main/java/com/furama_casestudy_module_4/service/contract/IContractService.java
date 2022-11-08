package com.furama_casestudy_module_4.service.contract;

import com.furama_casestudy_module_4.model.contract.Contract;
import com.furama_casestudy_module_4.model.facility.Facility;
import com.furama_casestudy_module_4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService extends IGeneralService<Contract> {

    Page<Contract> findAll(Pageable pageable);

    Page<Contract> findByName(Pageable pageable, String start, String end);

}
