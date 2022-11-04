package com.validate_song_information.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class TheSongDto implements Validator {
    private int id;
    @NotBlank (message = " Tên bài hát không được để trống")
    private String name;
    @NotBlank (message = " Tên nghệ sĩ không được để trống")
    private String performing;
    private String lyrics;
    @NotBlank (message = " Tên thể loại không được để trống")
    private String songType;
    private String author;


    public TheSongDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TheSongDto theSongDto = (TheSongDto) target;

        if (!theSongDto.name.matches("^[A-Za-zàáãạảăắ" +
                "ằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợù" +
                "úũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈ" +
                "ỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ ]{3,800}$")){
            errors.rejectValue("name","name.errors","tên bài hát không hợp lệ");
        }

        if (!theSongDto.performing.matches("^[A-Za-zàáãạảăắ" +
                "ằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợù" +
                "úũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈ" +
                "ỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ ]{3,800}$")){
            errors.rejectValue("performing","performing.errors","Tên nghệ sĩ biểu diễn không hợp lệ");
        }

        if (!theSongDto.songType.matches("^[A-Za-zàáãạảăắ" +
                "ằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợù" +
                "úũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈ" +
                "ỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ ]{3,800}$")){
            errors.rejectValue("songType","songType.errors","Tên loại bài hát không hợp lệ");
        }

    }
}

