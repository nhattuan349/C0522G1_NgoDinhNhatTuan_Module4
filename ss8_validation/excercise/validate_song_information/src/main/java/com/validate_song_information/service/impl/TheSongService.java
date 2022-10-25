package com.validate_song_information.service.impl;

import com.validate_song_information.model.TheSong;
import com.validate_song_information.repository.ITheSongRepository;
import com.validate_song_information.service.ITheSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TheSongService implements ITheSongService {

    @Autowired
    private ITheSongRepository theSongRepository;


    @Override
    public Iterable<TheSong> findAll() {
        return theSongRepository.findAll();
    }

    @Override
    public Optional<TheSong> findById(int id) {
        return theSongRepository.findById(id);
    }

    @Override
    public void save(TheSong theSong) {
        theSongRepository.save(theSong);
    }

    @Override
    public void remove(int id) {
        theSongRepository.deleteById(id);
    }

    @Override
    public Page<TheSong> findAll(Pageable pageable) {
        return theSongRepository.findAll(pageable);
    }

    @Override
    public Page<TheSong> findByName(Pageable pageable, String name) {
        return theSongRepository.findByBlogNameContaining(pageable,"%"+name+"%");
    }
}
