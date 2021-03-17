package com.codegym.lastwhisper.service.playlist;

import com.codegym.lastwhisper.model.Playlist;

import com.codegym.lastwhisper.repository.RepositoryPlaylist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistImp implements IPlaylistService {

    @Autowired
    private RepositoryPlaylist repositoryPlaylist;
    @Override
    public Iterable<Playlist> findAll() {
        return repositoryPlaylist.findAll() ;
    }

    @Override
    public Playlist save(Playlist playlist) {
        return repositoryPlaylist.save(playlist);
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return repositoryPlaylist.findById(id);
    }

    @Override
    public void remove(Long id) {
        repositoryPlaylist.deleteById(id);
    }

    @Override
    public Page<Playlist> findAll(Pageable pageable) {
        return repositoryPlaylist.findAll(pageable);
    }

    @Override
    public Page<Playlist> findAllByName(String name, Pageable pageable) {
        return repositoryPlaylist.findAllByNamePlaylistContains(name,pageable);
    }
}
