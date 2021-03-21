package com.codegym.lastwhisper.service.playlist;

import com.codegym.lastwhisper.model.Playlist;
import com.codegym.lastwhisper.model.PlaylistSong;
import com.codegym.lastwhisper.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPlaylistSong extends GeneralService<PlaylistSong> {
    public Iterable<PlaylistSong> findAll( Long id);
}
