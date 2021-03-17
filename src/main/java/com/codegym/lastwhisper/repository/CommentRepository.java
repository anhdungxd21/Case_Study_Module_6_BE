package com.codegym.lastwhisper.repository;

import com.codegym.lastwhisper.model.Comment;
import com.codegym.lastwhisper.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Iterable<Comment> getAllById(Long idType);
    Iterable<Comment> getCommentSongsBySongOrderByCreationTimeDesc(Song song);


//    Iterable<Comment> findAllById(Long id);
}
