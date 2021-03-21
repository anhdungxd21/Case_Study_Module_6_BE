package com.codegym.lastwhisper.dto;

import com.codegym.lastwhisper.model.Playlist;
import com.codegym.lastwhisper.model.Song;
import lombok.Data;

@Data
public class PlaylistSongDTO {
    private Long id;
    private Playlist playlist;
    private Song song;
}
