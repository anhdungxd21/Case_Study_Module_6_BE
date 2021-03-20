package com.c0920i1.lastWishper.repository;

import com.c0920i1.lastWishper.model.CommentPlaylist;
import com.c0920i1.lastWishper.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentPlaylistRepository extends JpaRepository<CommentPlaylist, Long> {
    Iterable<CommentPlaylist> getCommentPlaylistsByPlaylist(Playlist playlist);

}
