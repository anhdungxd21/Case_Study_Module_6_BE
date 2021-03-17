package com.codegym.lastwhisper.service.playlist;

import com.codegym.lastwhisper.model.Playlist;

import java.util.Optional;

public interface IPlayListService {
    Iterable<Playlist> getAll();
    Playlist save (Playlist playlist);
    Optional<Playlist> findById(Long id);
    void remove(Long id);
    Iterable<Playlist> findAllByUserUsername(String username);
    Playlist addSongToPlaylist(Long idSong, Long idPlaylist);
    Iterable<Playlist> findByName(String keyword);


}
