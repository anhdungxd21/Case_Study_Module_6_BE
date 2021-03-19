package com.codegym.lastwhisper.dto;

import com.codegym.lastwhisper.model.Singer;
import com.codegym.lastwhisper.model.User;
import lombok.Data;

@Data
public class SongJsonDto {
    private Long id;
    private String name;
    private String link;
    private String lyric;
    private UserDTO user;
    private Singer singer;
}
