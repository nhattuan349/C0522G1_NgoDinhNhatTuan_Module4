package com.validate_song_information.repository;

import com.validate_song_information.model.TheSong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITheSongRepository extends JpaRepository<TheSong, Integer> {

    @Query(value="select * from the_song where name like:name", nativeQuery = true)
    Page<TheSong> findByBlogNameContaining(Pageable pageable, String name);

}
