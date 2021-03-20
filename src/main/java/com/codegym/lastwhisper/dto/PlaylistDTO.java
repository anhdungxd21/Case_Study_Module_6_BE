package com.codegym.lastwhisper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaylistDTO {
    private Long id;
    private String name;
    private String description;
    private String avatar;
    private UserDTO user;
}
