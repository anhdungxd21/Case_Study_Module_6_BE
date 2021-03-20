package com.codegym.lastwhisper.service.playlist;

import com.codegym.lastwhisper.model.Playlist;
import com.codegym.lastwhisper.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPlaylistService extends GeneralService<Playlist> {
    public Page<Playlist> findAll(Pageable pageable);
    public Page<Playlist> findAllByNameAndUserID(String name, Long id, Pageable pageable);
    public Page<Playlist> findAllByUserId(Long id, Pageable pageable);
    public Page<Playlist> findAllByName(String name, Pageable pageable);
}
