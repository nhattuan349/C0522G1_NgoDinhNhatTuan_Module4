package com.furama_casestudy_module_4.service.impl.contract;

import com.furama_casestudy_module_4.model.contract.AttachFacility;
import com.furama_casestudy_module_4.repository.contract.IAttachFacilityRepository;
import com.furama_casestudy_module_4.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public Optional<AttachFacility> findById(int id) {
        return attachFacilityRepository.findById(id);
    }

    @Override
    public void save(AttachFacility attachFacility) {
        attachFacilityRepository.save(attachFacility);
    }

    @Override
    public void remove(int id) {
        attachFacilityRepository.deleteById(id);
    }

    @Override
    public Page<AttachFacility> findAll(Pageable pageable) {
        return attachFacilityRepository.findAll(pageable);
    }

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }
}
