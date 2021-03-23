package com.c0920i1.lastWishper.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Data
public class CommentPlaylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 1000)
    private String content;
    @ManyToOne
    private User user;
    @ManyToOne
    private Playlist playlist;


}
