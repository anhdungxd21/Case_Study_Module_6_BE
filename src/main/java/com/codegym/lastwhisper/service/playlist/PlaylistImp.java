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

    // find all play list not page
    @Override
    public Iterable<Playlist> findAll() {
        return repositoryPlaylist.findAll() ;
    }

    // save playlist
    @Override
    public Playlist save(Playlist playlist) {
        return repositoryPlaylist.save(playlist);
    }

    /// find playlist by id
    @Override
    public Optional<Playlist> findById(Long id) {
        return repositoryPlaylist.findById(id);
    }

    // remove playlist
    @Override
    public void remove(Long id) {
        repositoryPlaylist.deleteById(id);
    }

    // find all playlist page
    @Override
    public Page<Playlist> findAll(Pageable pageable) {
        return repositoryPlaylist.findAll(pageable);
    }

    // find all by name page
    @Override
    public Page<Playlist> findAllByNameAndUserID(String name, Long id, Pageable pageable) {
        return repositoryPlaylist.findAllByNameContainsAndUserId(name, id, pageable);
    }

    // find all by userId
    @Override
    public Page<Playlist>  findAllByUserId(Long id,Pageable pageable){
        return repositoryPlaylist.findAllByUserId(id, pageable);
    }
}
