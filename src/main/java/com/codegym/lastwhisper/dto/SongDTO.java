package com.codegym.lastwhisper.dto;

import lombok.Data;

@Data
public class SongDTO {
    private Long id;
    private String name;
    private String link;
    private String lyric;
    private Long userId;
    private Long typeId;
    private Long singerId;
}
