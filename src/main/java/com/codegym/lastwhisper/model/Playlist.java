package com.codegym.lastwhisper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.File;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Playlist extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namePlaylist;
    private String descriptionPlaylist;
    private String avatar;
    private Long idUser;
    private String typePlaylist;
}
