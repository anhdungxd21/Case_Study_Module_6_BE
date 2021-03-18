package com.codegym.lastwhisper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.File;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Playlist extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    private String namePlaylist;
    private String descriptionPlaylist;
    private String avatar;
    private Long   idUser;
    private String typePlaylist;
}
