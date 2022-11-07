package com.furama_casestudy_module_4.repository.facility;


import com.furama_casestudy_module_4.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = "select f.* from `facility` f join `facility_type` ft on f.facility_type_id = ft.id " +
            "where f.name like:name  and ft.name like:facilityType and f.status=0 order by f.id desc", nativeQuery = true)
    Page<Facility> findByFacilityNameAndFacilityTypeContaining(Pageable pageable,
                                                                    @Param("name") String name,
                                                                    @Param("facilityType") String facilityType);

    @Transactional
    @Modifying
    @Query(value = "update facility set status=1 where id=:id", nativeQuery = true)
    void delete(@Param("id") int id);

}
