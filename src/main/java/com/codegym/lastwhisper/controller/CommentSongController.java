package com.codegym.lastwhisper.controller;

import com.codegym.lastwhisper.model.CommentSong;
import com.codegym.lastwhisper.model.Song;
import com.codegym.lastwhisper.model.User;
import com.codegym.lastwhisper.repository.CommentSongRepository;
import com.codegym.lastwhisper.service.ISongService;
import com.codegym.lastwhisper.service.comment.commentSong.ICommentSongService;
import com.codegym.lastwhisper.service.impl.SongService;
import com.codegym.lastwhisper.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@CrossOrigin("*")
public class CommentSongController {

    @Autowired
    private ICommentSongService commentSongService;

    @Autowired
    private ISongService songService;

    @Autowired
    private UserService userService;

    @GetMapping("/commentSong/{songID}")
    public ResponseEntity<Iterable<CommentSong>> getCommentByIdSong(@PathVariable Long songID){
        Song song = songService.findById(songID);
        Iterable<CommentSong> listCommentSong = commentSongService.getCommentSongsBySongOrderByCreationTimeDesc(song);
        return new ResponseEntity<>(listCommentSong, HttpStatus.OK);
    }

    @PostMapping("/commentSong/{songID}/{username}")
    public ResponseEntity<CommentSong> postCommentSong(@PathVariable Long songID, @RequestBody CommentSong commentSong,@PathVariable String username){
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINESE);
        Date today = new Date();
        dateFormat.format(today);


        commentSong.setCreationTime(today);
        Song song = songService.findById(songID);
        User user = userService.findByFullName(username);
        commentSong.setUser(user);
        commentSong.setSong(song);
        return new ResponseEntity<>(commentSongService.save(commentSong),HttpStatus.CREATED);
    }



}