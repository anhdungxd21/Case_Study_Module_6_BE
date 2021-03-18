package com.codegym.lastwhisper.controller;

import com.codegym.lastwhisper.model.Response;
import com.codegym.lastwhisper.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("songs")
@CrossOrigin("*")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping
    public Response getAllSong(){
        Response response = new Response();
        response.setStatus(200);
        response.setMessage("Success");
        response.setData(songService.findAll());
        return response;
    }

    @PostMapping
    public Response postSong(){
        Response response = new Response();

        return response;
    }
}
