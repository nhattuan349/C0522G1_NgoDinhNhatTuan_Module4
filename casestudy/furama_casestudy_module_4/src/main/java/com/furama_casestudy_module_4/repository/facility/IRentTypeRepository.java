package com.furama_casestudy_module_4.repository.facility;

import com.furama_casestudy_module_4.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
}
