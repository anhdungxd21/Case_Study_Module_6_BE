package com.codegym.lastwhisper.service.playlist;

import com.codegym.lastwhisper.model.PlaylistSong;
import com.codegym.lastwhisper.repository.IPlaylistSongRepository;
import com.codegym.lastwhisper.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistSongImp implements IPlaylistSong{
    @Autowired
    IPlaylistSongRepository playlistSongRepository;

    /// fin all by playlist of id
    @Override
    public Iterable<PlaylistSong> findAll(Long id) {
        return playlistSongRepository.findAllByPlaylistId(id);
    }

    @Override
    public Page<PlaylistSong> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<PlaylistSong> findAll() {
        return playlistSongRepository.findAll();
    }

    @Override
    public Optional<PlaylistSong> findById(Long id) {
        return playlistSongRepository.findById(id);
    }

    @Override
    public PlaylistSong save(PlaylistSong playlistSong) {
        return playlistSongRepository.save(playlistSong);
    }

    @Override
    public void remove(Long id) {
        playlistSongRepository.deleteById(id);
    }


}
