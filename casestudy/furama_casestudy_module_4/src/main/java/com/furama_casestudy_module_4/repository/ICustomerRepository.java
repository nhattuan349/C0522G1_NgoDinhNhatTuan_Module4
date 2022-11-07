package com.furama_casestudy_module_4.repository;

import com.furama_casestudy_module_4.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where name like:name and status=0 order by id desc", nativeQuery = true)
    Page<Customer> findByBlogNameContaining(Pageable pageable, String name);

    @Query(value = "select * from customer where name like:name and email like:email order by id desc ", nativeQuery = true)
    Page<Customer> findByCustomerNameAndEmailContaining(Pageable pageable,
                                                        @Param("name") String name,
                                                        @Param("email") String email);



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



    @Transactional
    @Modifying
    @Query(value = "update customer set status=1 where id=:id", nativeQuery = true)
    void delete(@Param("id") int id);

}
