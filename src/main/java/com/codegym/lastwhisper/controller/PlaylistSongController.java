package com.codegym.lastwhisper.controller;


import com.codegym.lastwhisper.dto.PlaylistDTO;
import com.codegym.lastwhisper.dto.PlaylistSongDTO;
import com.codegym.lastwhisper.dto.TuConverterDTO;
import com.codegym.lastwhisper.model.PlaylistSong;
import com.codegym.lastwhisper.service.playlist.IPlaylistSong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@CrossOrigin("*")
@RestController
@RequestMapping("/playlistSongs")
public class PlaylistSongController {
    @Autowired
    IPlaylistSong iPlaylistSong;
    @Autowired
    TuConverterDTO tuConverterDTO;
    // all song of playlist
    @GetMapping("/{idPlaylist}")
    public ResponseEntity<Iterable<PlaylistSongDTO>> getAllSongInPlaylists(@PathVariable(value = "idPlaylist",required = false) Long idPlaylist){
        if (iPlaylistSong.findAll(idPlaylist).toString().isEmpty()) return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        List<PlaylistSong> playlistSongs =(List<PlaylistSong>) iPlaylistSong.findAll(idPlaylist);
        List<PlaylistSongDTO> playlistSongDTOS=new ArrayList<>();
        for(PlaylistSong playlistSong: playlistSongs){
            playlistSongDTOS.add(tuConverterDTO.playlistSongDTOConvert(playlistSong));
        }
        return new ResponseEntity<>((Iterable<PlaylistSongDTO>) playlistSongDTOS,HttpStatus.OK);
    }

    // add multi song in playlist
    @PostMapping
    public ResponseEntity<PlaylistSongDTO>  createSongInPlaylist(@RequestBody(required = false) PlaylistSongDTO playlistSongDTO){
        iPlaylistSong.save(tuConverterDTO.playlistSongConvert(playlistSongDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // delete song in playlist
    @DeleteMapping("/{id}")
    public ResponseEntity<PlaylistSong> deletePlaylistsSong(@PathVariable(value = "id",required = false) Long id){
        if (!iPlaylistSong.findById(id).isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        iPlaylistSong.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // search song with name
    public ResponseEntity<So>
}
