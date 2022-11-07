package com.furama_casestudy_module_4.service.impl.facility;

import com.furama_casestudy_module_4.model.facility.RentType;
import com.furama_casestudy_module_4.repository.facility.IRentTypeRepository;
import com.furama_casestudy_module_4.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public Optional<RentType> findById(int id) {
        return rentTypeRepository.findById(id);
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void remove(int id) {
        rentTypeRepository.deleteById(id);
    }

    @Override
    public Page<RentType> findAll(Pageable pageable) {
        return rentTypeRepository.findAll(pageable);
    }

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
