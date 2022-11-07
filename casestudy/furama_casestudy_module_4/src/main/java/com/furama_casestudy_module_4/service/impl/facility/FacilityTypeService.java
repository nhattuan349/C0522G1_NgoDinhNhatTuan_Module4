package com.furama_casestudy_module_4.service.impl.facility;

import com.furama_casestudy_module_4.model.facility.FacilityType;
import com.furama_casestudy_module_4.repository.facility.IFacilityTypeRepository;
import com.furama_casestudy_module_4.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public Optional<FacilityType> findById(int id) {
        return facilityTypeRepository.findById(id);
    }

    @Override
    public void save(FacilityType facilityType) {
        facilityTypeRepository.save(facilityType);
    }

    @Override
    public void remove(int id) {
        facilityTypeRepository.deleteById(id);
    }

    @Override
    public Page<FacilityType> findAll(Pageable pageable) {
        return facilityTypeRepository.findAll(pageable);
    }

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
