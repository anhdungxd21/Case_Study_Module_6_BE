package com.c0920i1.lastWishper.controller;

import com.c0920i1.lastWishper.model.CommentSong;
import com.c0920i1.lastWishper.model.Song;
import com.c0920i1.lastWishper.model.User;
import com.c0920i1.lastWishper.service.commentSong.CommentSongService;
import com.c0920i1.lastWishper.service.song.SongService;
import com.c0920i1.lastWishper.service.user.UserService;
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
    private CommentSongService commentSongService;

    @Autowired
    private SongService songService;
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
        /*ZonedDateTime zoned = ZonedDateTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.CHINESE);
        Date date = Date.from(zoned.toLocalDate().atStartOfDay(zoned.getZone()).toInstant());
        zoned.format(pattern);*/

        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINESE);
        Date today = new Date();
        dateFormat.format(today);


        commentSong.setCreationTime(today);
        Song song = songService.findById(songID);
        User user = userService.findByUsername(username);
        commentSong.setUser(user);
        commentSong.setSong(song);
        return new ResponseEntity<>(commentSongService.save(commentSong),HttpStatus.CREATED);
    }

}
