package com.codegym.lastwhisper.service.playlist;

import com.codegym.lastwhisper.model.Playlist;
import com.codegym.lastwhisper.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PlayListService implements IPlayListService {

    @Autowired
    private PlayListRepository playListRepository;
    @Override
    public Iterable<Playlist> getAll() {
        return null;
    }

    @Override
    public Playlist save(Playlist playlist) {
        return null;
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Iterable<Playlist> findAllByUserUsername(String username) {
        return null;
    }

    @Override
    public Playlist addSongToPlaylist(Long idSong, Long idPlaylist) {
        return null;
    }

    @Override
    public Iterable<Playlist> findByName(String keyword) {
        return null;
    }
}