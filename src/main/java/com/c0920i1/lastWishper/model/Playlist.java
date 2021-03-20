package com.c0920i1.lastWishper.model;

//import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date creationTime;
    private String avatar;
    private Long view;
    @ManyToOne
    private User user;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Song> songs;
}
