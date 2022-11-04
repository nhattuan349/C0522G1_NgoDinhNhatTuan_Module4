package com.furama_casestudy_module_4.repository;

import com.furama_casestudy_module_4.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where name like:name", nativeQuery = true)
    Page<Customer> findByCustomerNameContaining(Pageable pageable, String name);

    @Query(value = "select * from customer where name like %:name% and email like %:email%" +
            " and customer.status =:status", nativeQuery = true)
    Page<Customer> findPageNameAndEmail(@Param("name") String name,
                                        @Param("email") String email,
                                        @Param("status") String status,
                                        Pageable pageable);

    @Query(value = "select * from customer where customer.name like %:name% and customer.email " +
            "like %:email% and customer_type_id =:customerTypeId and customer.status =:status", nativeQuery = true)
    Page<Customer> findByNameAndEmailAndCustomerTypeId(@Param("name") String name,
                                                       @Param("email") String email,
                                                       @Param("status") String status,
                                                       @Param("customerTypeId") String customerTypeId,
                                                       Pageable pageable);

    @Query(value = "select * from customer where customer.status =:status", nativeQuery = true)
    Page<Customer> findPageStatus(@Param("status") String status,
                                  Pageable pageable);



}
