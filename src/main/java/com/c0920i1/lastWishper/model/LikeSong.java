package com.c0920i1.lastWishper.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class LikeSong {
    @EmbeddedId
    private LikeSongId likeSongId;

    public LikeSong(LikeSongId likeSongId) {
        this.likeSongId = likeSongId;
    }

    public LikeSong() {
    }
}
