package com.c0920i1.lastWishper.service.commentSong;

import com.c0920i1.lastWishper.model.CommentSong;
import com.c0920i1.lastWishper.model.Song;
import com.c0920i1.lastWishper.repository.CommentSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentSongServiceImpl implements CommentSongService {

    @Autowired
    CommentSongRepository commentSongRepository;

    @Override
    public Optional<CommentSong> findById(Long id) {
        return commentSongRepository.findById(id);
    }

    @Override
    public Iterable<CommentSong> findAll() {
        return commentSongRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        commentSongRepository.deleteById(id);
    }

    @Override
    public CommentSong save(CommentSong commentSong) {
        return commentSongRepository.save(commentSong);
    }

    @Override
    public Iterable<CommentSong> getCommentSongsBySongOrderByCreationTimeDesc(Song song) {
        return commentSongRepository.getCommentSongsBySongOrderByCreationTimeDesc(song);
    }
}
