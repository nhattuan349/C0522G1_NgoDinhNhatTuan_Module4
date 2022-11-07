package com.furama_casestudy_module_4.repository.customer;

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

    @Query(value = "select * from customer where name like:name and email like:email and status=0 order by id desc ", nativeQuery = true)
    Page<Customer> findByCustomerNameAndEmailContaining(Pageable pageable,
                                                        @Param("name") String name,
                                                        @Param("email") String email);

    @Query(value = "select c.* from `customer` c join `customer_type` ct on c.customer_type_id = ct.id " +
            "where c.name like:name and c.email like:email and ct.name like:customerType and c.status=0 order by c.id desc", nativeQuery = true)
    Page<Customer> findByCustomerNameEmailAndCustomerTypeContaining(Pageable pageable,
                                                        @Param("name") String name,
                                                        @Param("email") String email,
                                                        @Param("customerType") String customerType);


    @Transactional
    @Modifying
    @Query(value = "update customer set status=1 where id=:id", nativeQuery = true)
    void delete(@Param("id") int id);

}
