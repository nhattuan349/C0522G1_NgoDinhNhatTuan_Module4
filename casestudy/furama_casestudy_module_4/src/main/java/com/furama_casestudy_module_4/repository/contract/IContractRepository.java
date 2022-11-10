package com.furama_casestudy_module_4.repository.contract;

import com.furama_casestudy_module_4.dto.CustomerHavingBooking;
import com.furama_casestudy_module_4.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select ctr.*" +
            " from `contract` ctr" +
            " join `customer` c on ctr.customer_id = c.id " +
            " join `employee` e on ctr.employee_id = e.id " +
            " join `facility` f on ctr.facility_id = f.id" +
            " where ctr.start_date like:start and ctr.end_date like:end and ctr.status=0" +
            " order by ctr.id desc", nativeQuery = true)
    Page<Contract> findByContractStartAndEndDateContaining(Pageable pageable,
                                                               @Param("start") String start,
                                                               @Param("end") String end
                                                               );

//    @Query(value = "select c.name customerName, ctr.start_date startDate, ctr.end_date endDate,c.id customerId," +
//            "  GROUP_CONCAT(f.name) as facilityList " +
//            " from `contract` ctr" +
//            " join `customer` c on ctr.customer_id = c.id " +
//            " join `employee` e on ctr.employee_id = e.id " +
//            " join `facility` f on ctr.facility_id = f.id" +
//            " where ctr.start_date like:start and ctr.end_date like:end and ctr.status=0" +
//            "group by c.name" +
//            " order by ctr.id desc", nativeQuery = true)
//    Page<CustomerHavingBooking> findByContractStartAndEndDateContainingInterfacce(Pageable pageable,
//                                                                        @Param("start") String start,
//                                                                        @Param("end") String end
//    );

}
