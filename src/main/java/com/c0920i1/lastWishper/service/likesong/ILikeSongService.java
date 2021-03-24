package com.c0920i1.lastWishper.service.likesong;

import com.c0920i1.lastWishper.model.LikeSong;
import com.c0920i1.lastWishper.model.LikeSongId;

import java.util.Optional;

public interface ILikeSongService {
    Iterable<LikeSong> findAll();
    Optional<LikeSong> findById(LikeSongId likeSongId);
    LikeSong save(LikeSong likeSong);
    void delete(LikeSongId likeSongId);
}
