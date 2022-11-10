package com.furama_casestudy_module_4.service.contract;

import com.furama_casestudy_module_4.model.contract.ContractDetail;
import com.furama_casestudy_module_4.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService extends IGeneralService<ContractDetail> {

    Page<ContractDetail> findAll(Pageable pageable);

    List<ContractDetail> findAll();

}
