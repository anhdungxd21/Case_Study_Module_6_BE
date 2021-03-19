package com.codegym.lastwhisper.controller;

import com.codegym.lastwhisper.dto.ConverterDTO;
import com.codegym.lastwhisper.dto.SongDTO;
import com.codegym.lastwhisper.model.Response;
import com.codegym.lastwhisper.model.Song;
import com.codegym.lastwhisper.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("songs")
@CrossOrigin("*")
public class SongController {
    @Autowired
    private ISongService songService;

    @Autowired
    private ConverterDTO converter;

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable("id")Long id){
        Optional<Song> optionalSong =  songService.findById(id);
        if(optionalSong.isPresent()){
            return new ResponseEntity<Song>(optionalSong.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public Response getAllSong(){
        Response response = new Response();
        response.setStatus(200);
        response.setMessage("Success");
        response.setData(songService.findAll());
        return response;
    }

    @PostMapping
    public Response postSong(@RequestBody SongDTO songDTO){
        Song song = converter.songConverter(songDTO);
        Response response = new Response();
        response.setStatus(201);
        response.setMessage("Create success");
        response.setData(songService.save(song));
        return response;
    }
}
