package com.validate_song_information.service;

import com.validate_song_information.model.TheSong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITheSongService extends IGeneralService<TheSong> {

    Page<TheSong> findAll(Pageable pageable);

    Page<TheSong> findByName(Pageable pageable, String name );

}
