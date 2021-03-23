package com.c0920i1.lastWishper.controller;

import com.c0920i1.lastWishper.model.*;
import com.c0920i1.lastWishper.service.commentPlaylist.CommentPlaylistService;
import com.c0920i1.lastWishper.service.playlist.PlayListService;
import com.c0920i1.lastWishper.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CommentPlaylistController {
    @Autowired
    private PlayListService playListService;

    @Autowired
    private CommentPlaylistService commentPlaylistService;

    @Autowired
    private UserService userService;


    @GetMapping("/commentPlaylist/{playlistId}")
    public ResponseEntity<Iterable<CommentPlaylist>> getCommentByIdPlaylist(@PathVariable Long playlistId) {
        Optional<Playlist> playlist = playListService.findById(playlistId);
        Iterable<CommentPlaylist> listCommentPlaylist = commentPlaylistService.getCommentPlaylistsByPlaylist(playlist.get());
        return new ResponseEntity<>(listCommentPlaylist, HttpStatus.OK);

    }

    @PostMapping("/commentPlaylist/{playlistId}/{username}")
    public ResponseEntity<CommentPlaylist> postCommentSong(@PathVariable Long playlistId, @RequestBody CommentPlaylist commentPlaylist, @PathVariable String username) {
        Optional<Playlist> playlist = playListService.findById(playlistId);
        User user = userService.findByUsername(username);
        commentPlaylist.setUser(user);
        commentPlaylist.setPlaylist(playlist.get());
        return new ResponseEntity<>(commentPlaylistService.save(commentPlaylist), HttpStatus.CREATED);
    }
}
