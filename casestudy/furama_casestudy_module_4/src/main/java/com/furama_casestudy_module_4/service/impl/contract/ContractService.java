package com.furama_casestudy_module_4.service.impl.contract;

import com.furama_casestudy_module_4.dto.CustomerHavingBooking;
import com.furama_casestudy_module_4.model.contract.Contract;
import com.furama_casestudy_module_4.model.facility.Facility;
import com.furama_casestudy_module_4.repository.contract.IContractRepository;
import com.furama_casestudy_module_4.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Optional<Contract> findById(int id) {
        return contractRepository.findById(id);
    }

//    @Override
//    public Page<CustomerHavingBooking> findByNameInterface(Pageable pageable, String start, String end) {
//        return contractRepository.findByContractStartAndEndDateContainingInterfacce(
//                pageable, "%" + start + "%","%" + end + "%");
//    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(int id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findByName(Pageable pageable, String start, String end) {
        return contractRepository.findByContractStartAndEndDateContaining(
                pageable, "%" + start + "%","%" + end + "%");
    }
//
//    @Override
//    public Page<Contract> findByName(Pageable pageable, String start, String end) {
//        return contractRepository.findByContractStartAndEndDateContaining(
//                pageable, "%" + start + "%","%" + end + "%");
//    }



}
