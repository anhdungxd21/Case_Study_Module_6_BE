package com.codegym.lastwhisper.service.comment;

import com.codegym.lastwhisper.model.Comment;
import com.codegym.lastwhisper.model.Song;
import com.codegym.lastwhisper.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }


    @Override
    public Iterable<Comment> getAllByIdType(Long id) {
        return commentRepository.getAllById(id);
    }
}