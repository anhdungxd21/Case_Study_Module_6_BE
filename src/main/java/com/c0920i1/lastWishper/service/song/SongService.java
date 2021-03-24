package com.c0920i1.lastWishper.service.song;

import com.c0920i1.lastWishper.model.Song;

import java.math.BigInteger;
import java.util.List;

public interface SongService {
    Iterable<Song> findAll();
    Iterable<Song> listLatest();
    Song findById(Long id);
    Song save(Song song);
    void delete(Long id);

    Iterable<Song> listSongsByUser(Long id);
    Iterable<Song> findByName(String keyword);
    Iterable<Song> getList10SongInTopView();
    Iterable<Song> findAllByUserId(Long idUser);
    Iterable<Song> topLikeSong();
    List<BigInteger> likeNumber();

}
