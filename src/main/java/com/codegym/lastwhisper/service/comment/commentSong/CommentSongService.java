package com.codegym.lastwhisper.service.comment.commentSong;

import com.codegym.lastwhisper.model.CommentSong;
import com.codegym.lastwhisper.model.Song;
import com.codegym.lastwhisper.repository.CommentSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentSongService implements ICommentSongService {

    @Autowired
    CommentSongRepository commentSongRepository;

    @Override
    public Iterable<CommentSong> getCommentSongsBySongOrderByCreationTimeDesc(Song song) {
        return commentSongRepository.getCommentSongsBySongOrderByCreationTimeDesc(song);
    }

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
}