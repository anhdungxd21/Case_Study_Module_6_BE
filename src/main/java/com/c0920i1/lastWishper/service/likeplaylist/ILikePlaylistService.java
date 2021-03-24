package com.c0920i1.lastWishper.service.likeplaylist;

import com.c0920i1.lastWishper.model.LikePlaylist;
import com.c0920i1.lastWishper.model.LikePlaylistId;

import java.util.Optional;

public interface ILikePlaylistService {
    Iterable<LikePlaylist> findAll();
    Optional<LikePlaylist> findById(LikePlaylistId likePlaylistId);
    LikePlaylist save(LikePlaylist likePlaylist);
    void delete(LikePlaylistId likePlaylistId);
}
