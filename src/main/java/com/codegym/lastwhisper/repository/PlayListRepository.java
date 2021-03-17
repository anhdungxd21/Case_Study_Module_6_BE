package com.codegym.lastwhisper.repository;

import com.codegym.lastwhisper.model.Playlist;

public interface PlayListRepository {
    Iterable<Playlist> findAllByUserUsername(String username);

}
