package com.application_to_borrow_books.repository;

import com.application_to_borrow_books.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Query(value = " select * from book" +
            " join oder_book on book.id = oder_book.book_id" +
            " join oder on oder_book.oder_id = oder.id " +
            " where oder.code =:code", nativeQuery = true)
    Book findByCode(@Param("code") long code);

    @Query(value="select * from book where name like:name", nativeQuery = true)
    Page<Book> findByBlogNameContaining(Pageable pageable, String name);

}
