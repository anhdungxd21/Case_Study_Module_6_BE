package com.codegym.lastwhisper.controller;

import com.codegym.lastwhisper.model.CommentPlaylist;
import com.codegym.lastwhisper.model.Playlist;
import com.codegym.lastwhisper.service.comment.commentPlaylist.CommentPlaylistService;
import com.codegym.lastwhisper.service.comment.commentPlaylist.ICommentPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CommentPlaylistController {
//    @Autowired
//    private PlayListService playListService;

    @Autowired
    private ICommentPlaylistService commentPlaylistServices;

    @GetMapping("/commentPlaylist/{idPlaylist}")
    public ResponseEntity<Iterable<CommentPlaylist>> getCommentByIdPlaylist(@PathVariable Long idPlaylist){
//        Optional<Playlist> playlist = playListService.findById(idPlaylist);
        Iterable<CommentPlaylist> listCommentPlaylist = commentPlaylistServices.getCommentPlaylistsByPlaylist(playlist.get());
        return new ResponseEntity<>(listCommentPlaylist, HttpStatus.OK);

    }
}