package com.c0920i1.lastWishper.service.commentPlaylist;

import com.c0920i1.lastWishper.model.CommentPlaylist;
import com.c0920i1.lastWishper.model.Playlist;
import com.c0920i1.lastWishper.repository.CommentPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentPlaylistService implements ICommentPlaylistService {

    @Autowired
    private CommentPlaylistRepository commentPlaylistRepository;

    @Override
    public Iterable<CommentPlaylist> getCommentPlaylistsByPlaylist(Playlist playlist) {
        return commentPlaylistRepository.getCommentPlaylistsByPlaylist(playlist);
    }

    @Override
    public Optional<CommentPlaylist> findById(Long id) {
        return commentPlaylistRepository.findById(id);
    }

    @Override
    public Iterable<CommentPlaylist> findAll() {
        return commentPlaylistRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        commentPlaylistRepository.deleteById(id);
    }

    @Override
    public CommentPlaylist save(CommentPlaylist commentPlaylist) {
        return commentPlaylistRepository.save(commentPlaylist);
    }
}
