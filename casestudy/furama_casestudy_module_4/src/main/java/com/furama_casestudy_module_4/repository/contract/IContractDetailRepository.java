package com.furama_casestudy_module_4.repository.contract;

import com.furama_casestudy_module_4.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {

}
