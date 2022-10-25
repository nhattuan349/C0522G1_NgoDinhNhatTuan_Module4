package com.validate_song_information.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TheSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String performing;
    private String lyrics;
    private String songType;
    private String author;

    public TheSong() {
    }

    public TheSong(int id, String name, String performing, String lyrics, String songType, String author) {
        this.id = id;
        this.name = name;
        this.performing = performing;
        this.lyrics = lyrics;
        this.songType = songType;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerforming() {
        return performing;
    }

    public void setPerforming(String performing) {
        this.performing = performing;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
