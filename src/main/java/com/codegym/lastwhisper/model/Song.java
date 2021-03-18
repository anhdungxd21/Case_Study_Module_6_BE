package com.codegym.lastwhisper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Song extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
<<<<<<< HEAD
    private String description;
    private String link;
    private String avatar;
    private Long userId;
    private Long singerId;
=======
    private String link;
    private String lyric;
    private Long userId;
    private Long typeId;
    private Long singerId;

>>>>>>> f0e4d29f4187d35d7b4a81522684d992f5f447f3
}
