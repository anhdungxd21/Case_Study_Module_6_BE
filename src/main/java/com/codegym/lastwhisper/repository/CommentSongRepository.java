package com.codegym.lastwhisper.repository;

import com.codegym.lastwhisper.model.CommentSong;
import com.codegym.lastwhisper.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentSongRepository extends JpaRepository<CommentSong,Long> {
    Iterable<CommentSong> getCommentSongsBySongOrderByCreationTimeDesc(Song song);

}
