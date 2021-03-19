package com.codegym.lastwhisper.service.song;

import com.codegym.lastwhisper.model.Song;
import com.codegym.lastwhisper.service.GeneralService;

import java.util.List;

public interface ISongService extends GeneralService<Song> {
    List<Song> findAllByNameContains(String name);
}
