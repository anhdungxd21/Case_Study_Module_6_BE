package com.c0920i1.lastWishper.controller;

import com.c0920i1.lastWishper.model.Playlist;
import com.c0920i1.lastWishper.model.Singer;
import com.c0920i1.lastWishper.service.singer.ISingerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    ISingerService singerService;

    @GetMapping
    public ResponseEntity<Iterable<Singer>> getAllPlaylist(@RequestParam("page") Optional<String> optionalPage,
                                                                @RequestParam("size") Optional<String> optionalSize,
                                                                @RequestParam("sort") Optional<String> optionalSort) {
        Integer page = 0;
        Integer size = 5;
        String  sort = "name";
        if (optionalPage.isPresent()) page = Integer.parseInt(optionalPage.get());
        if (optionalSize.isPresent()) size = Integer.parseInt(optionalSize.get());
        if (optionalSort.isPresent()) sort = optionalSort.get();
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Singer> singers = singerService.findAll(pageable);
        if (singers.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(singers, HttpStatus.OK);
    }
//    public ResponseEntity<Iterable<Singer>> getAll(){
//        Iterable<Singer> singerIterable = singerService.findAll();
//        return new ResponseEntity<>(singerService.findAll(), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Singer> getSingerById(@PathVariable Long id){
        Optional<Singer> singerOptional = singerService.findById(id);
        return singerOptional.map(singer -> new ResponseEntity<>(singer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Singer> createNewSinger(@RequestBody Singer singer){
        return new ResponseEntity<>(singerService.save(singer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Singer> updateSinger(@PathVariable Long id, @RequestBody Singer singer){
        Optional<Singer> singerOptional = singerService.findById(id);
        return singerOptional.map(singer1 -> {
            singer.setId(singer1.getId());
            if (singer.getName().equalsIgnoreCase("")){
                singer.setName(singer1.getName());
            }
            return new ResponseEntity<>(singerService.save(singer), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Singer> deleteSinger(@PathVariable Long id){
        Optional<Singer> singerOptional = singerService.findById(id);
        return singerOptional.map(singer -> {
            singerService.remove(id);
            return new ResponseEntity<Singer>(HttpStatus.NO_CONTENT);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @ApiOperation(value = "find by name singer" , response = Singer.class)
    @GetMapping("/searchSinger/{keyword}")
    public ResponseEntity<Iterable<Singer>> searchByNameContains(@PathVariable Optional<String> keyword){
        Iterable<Singer> singerIterable = singerService.findAllByNameContains(keyword.get());
        List<Singer> singerList = new ArrayList<>();
        singerIterable.forEach(singerList::add);
        if (singerList.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(singerIterable,HttpStatus.OK);
        }
    }
    @ApiOperation(value = "find by name singer" , response = Singer.class)
    @GetMapping("/editSinger/{keyword}")
    public ResponseEntity<Singer> searchByName(@PathVariable Optional<String> keyword){
        Optional<Singer> singerOptional = singerService.findByName(keyword.get());
        return singerOptional.map(singer -> {
            return new ResponseEntity<>(singer, HttpStatus.OK);
        }).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
