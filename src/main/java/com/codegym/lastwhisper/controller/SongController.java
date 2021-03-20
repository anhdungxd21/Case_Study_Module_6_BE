package com.codegym.lastwhisper.controller;

import com.codegym.lastwhisper.dto.ConverterDTO;
import com.codegym.lastwhisper.dto.SongDTO;
import com.codegym.lastwhisper.dto.SongJsonDto;
import com.codegym.lastwhisper.model.Response;
import com.codegym.lastwhisper.model.Song;
import com.codegym.lastwhisper.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

@RestController
@RequestMapping("songs")
@CrossOrigin("*")
public class SongController {
    @Autowired
    private ISongService songService;

    @Autowired
    private ConverterDTO converter;



    @GetMapping
    public Response getAllSong(@RequestParam(value = "search", required = false) Optional<String> search){
        Response response = new Response();
        if(search.isPresent()){
            List getAllSong = songService.findAllByNameContains(search.get());
            Stack reverseSong = new Stack();
            ArrayList<SongJsonDto> sendList = new ArrayList();
            for(int i = 0; i < (getAllSong.size()<10?getAllSong.size():10); i++){
                reverseSong.push(getAllSong.get(i));
            }
            for (int i = 0; i < reverseSong.size(); i++){
                Song song = (Song) reverseSong.pop();
                sendList.add(converter.converterSongToSend(song));
            }
            response.setStatus(200);
            response.setMessage("Success");
            response.setData(sendList);
            return response;
        } else {
            List getAllSong = (List) songService.findAll();
            Stack reverseSong = new Stack();
            ArrayList<SongJsonDto> sendList = new ArrayList();
            for(int i = 0; i < (getAllSong.size()<10?getAllSong.size():10); i++){
                reverseSong.push(getAllSong.get(i));
            }
            for (int i = 0; i < reverseSong.size(); i++){
                Song song = (Song) reverseSong.pop();
                sendList.add(converter.converterSongToSend(song));
            }
            response.setStatus(200);
            response.setMessage("Success");
            response.setData(sendList);
            return response;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getSongById(@PathVariable("id")Long id){
        Optional<Song> optionalSong =  songService.findById(id);
        if(optionalSong.isPresent()){
            SongJsonDto songJsonDto = converter.converterSongToSend(optionalSong.get());
            return new ResponseEntity(songJsonDto, HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Response postSong(@RequestBody SongDTO songDTO){
        Song song = converter.songConverter(songDTO);
        Response response = new Response();
        response.setStatus(202);
        response.setMessage("Create success");
        response.setData(songService.save(song));
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity putSong(@PathVariable("id")Long id,
                                  @RequestBody SongDTO songDTO){
        Optional<Song> optionalSong = songService.findById(id);
        if(optionalSong.isPresent()){
            Song song = converter.songConverter(songDTO);
            songService.save(song);
            return new ResponseEntity(songDTO,HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteSong(@PathVariable Long id){
        Optional<Song> songOptional = songService.findById(id);
        if(songOptional.isPresent()){
            songService.remove(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else  {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}