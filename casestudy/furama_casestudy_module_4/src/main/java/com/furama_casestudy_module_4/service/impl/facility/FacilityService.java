package com.furama_casestudy_module_4.service.impl.facility;

import com.furama_casestudy_module_4.model.facility.Facility;
import com.furama_casestudy_module_4.repository.facility.IFacilityRepository;
import com.furama_casestudy_module_4.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;


    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public Page<Facility> findByName(Pageable pageable, String name, String facilityType) {
        return facilityRepository.findByFacilityNameAndFacilityTypeContaining(pageable, "%" + name + "%","%" + facilityType + "%");
    }

    @Override
    public Iterable<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Optional<Facility> findById(int id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(int id) {
        facilityRepository.delete(id);
    }
}
