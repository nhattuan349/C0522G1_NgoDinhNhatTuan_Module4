package com.application_to_borrow_books.repository;

import com.application_to_borrow_books.model.Book;
import com.application_to_borrow_books.model.Oder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IOderRepository extends JpaRepository<Oder,Integer> {

    @Query(value = " select * from oder where code =:code",nativeQuery = true)
    Oder findByCode(@Param("code") long code);

    @Query(value="select * from oder where name =:code", nativeQuery = true)
    Page<Oder> findByBlogNameContaining(Pageable pageable, String code);

}
