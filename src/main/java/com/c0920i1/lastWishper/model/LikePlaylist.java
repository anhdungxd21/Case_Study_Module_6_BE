package com.c0920i1.lastWishper.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class LikePlaylist {
    @EmbeddedId
    private LikePlaylistId likePlaylistId;

    public LikePlaylist(LikePlaylistId likePlaylistId) {
        this.likePlaylistId = likePlaylistId;
    }

    public LikePlaylist() {
    }
}
