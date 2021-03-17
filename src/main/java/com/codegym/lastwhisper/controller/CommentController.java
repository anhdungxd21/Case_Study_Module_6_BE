package com.codegym.lastwhisper.controller;

import com.codegym.lastwhisper.model.Comment;
import com.codegym.lastwhisper.model.Song;
import com.codegym.lastwhisper.model.User;
import com.codegym.lastwhisper.repository.CommentRepository;
import com.codegym.lastwhisper.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@CrossOrigin("*")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository ;
    private Object Comment;

    @GetMapping("/commentSong/{songID}")
    public ResponseEntity<Iterable<Comment>> getCommentByIdSong(@PathVariable Song commentId){
//        Song song = songService.findById(songID);
        Iterable<Comment> listCommentSong = commentRepository.getCommentSongsBySongOrderByCreationTimeDesc(commentId);
        return new ResponseEntity<>(listCommentSong, HttpStatus.OK);
    }
    @PostMapping("/commentSong/{songID}/{username}")
    public ResponseEntity<Comment> postCommentSong(@PathVariable Long songID, @RequestBody Comment comment,@PathVariable String username){
        /*ZonedDateTime zoned = ZonedDateTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.CHINESE);
        Date date = Date.from(zoned.toLocalDate().atStartOfDay(zoned.getZone()).toInstant());
        zoned.format(pattern);*/

        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINESE);
        Date today = new Date();
        dateFormat.format(today);


        return null;
//        return new ResponseEntity<Song>(commentRepository.getCommentSongsBySongOrderByCreationTimeDesc(),HttpStatus.CREATED);
    }

}