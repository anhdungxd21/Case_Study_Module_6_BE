package com.codegym.lastwhisper.dto;

import lombok.Data;

@Data
public class PlaylistDTO {
    private Long id;
    private String name;
    private String description;
    private String avatar;
    private String userFullName;
}
