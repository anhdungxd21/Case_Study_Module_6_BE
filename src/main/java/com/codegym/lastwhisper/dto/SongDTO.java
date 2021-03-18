package com.codegym.lastwhisper.dto;

import lombok.Data;

@Data
public class SongDTO {
    private String name;
    private String link;
    private String lyric;
    private String userId;
    private String typeId;
    private Long singerId;
}
