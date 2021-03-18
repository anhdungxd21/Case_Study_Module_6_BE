package com.codegym.lastwhisper.repository;

import com.codegym.lastwhisper.model.CommentPlaylist;
import com.codegym.lastwhisper.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentPlaylistRepository extends JpaRepository<CommentPlaylist, Long> {
    Iterable<CommentPlaylist> getCommentPlaylistsByPlaylist(Playlist playlist);
}