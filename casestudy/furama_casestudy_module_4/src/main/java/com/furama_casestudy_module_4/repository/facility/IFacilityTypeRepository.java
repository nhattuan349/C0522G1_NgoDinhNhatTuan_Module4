package com.furama_casestudy_module_4.repository.facility;

import com.furama_casestudy_module_4.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityTypeRepository extends JpaRepository<FacilityType, Integer> {

}
