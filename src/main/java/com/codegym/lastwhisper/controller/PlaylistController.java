package com.codegym.lastwhisper.controller;
import com.codegym.lastwhisper.dto.PlaylistDTO;
import com.codegym.lastwhisper.dto.TuConverterDTO;
import com.codegym.lastwhisper.model.Playlist;
import com.codegym.lastwhisper.service.playlist.IPlaylistService;
import com.codegym.lastwhisper.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private IPlaylistService playlistService;
    @Autowired
    private TuConverterDTO tuConverterDTO;

    // take playlist for customers
    @GetMapping
    public ResponseEntity<Iterable<PlaylistDTO>> getAllPlaylist(@RequestParam("page") Optional<String> optionalPage,
                                                                @RequestParam("size") Optional<String> optionalSize,
                                                                @RequestParam("sort") Optional<String> optionalSort) {
        Integer page = 0;
        Integer size = 2;
        String  sort = "name";
        if (optionalPage.isPresent()) page = Integer.parseInt(optionalPage.get());
        if (optionalSize.isPresent()) size = Integer.parseInt(optionalSize.get());
        if (optionalSort.isPresent()) sort = optionalSort.get();
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Playlist> playlists = playlistService.findAll(pageable);
        if (playlists.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(tuConverterDTO.playlistConvertPlaylistDTO(playlists,pageable), HttpStatus.OK);
    }

    // find one by id for show detail one 1 playlist
    @GetMapping("/{id}")
    public ResponseEntity<PlaylistDTO> playlistDetail(@PathVariable Long id) {
        Optional<Playlist> playlist = playlistService.findById(id);
        if (playlist.isPresent()) {
            return new ResponseEntity<>(tuConverterDTO.playlistDTOConvert(playlist.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // search by name
    @GetMapping(value = {"/search/{id}","/search"})
    public ResponseEntity<Iterable<PlaylistDTO>> getAllPlaylistByName(@RequestParam("name") Optional<String> nameSearch,
                                                                      @PathVariable Map<String, String> userID,
                                                                      @RequestParam("page") Optional<String> optionalPage,
                                                                      @RequestParam("size") Optional<String> optionalSize,
                                                                      @RequestParam("sort") Optional<String> optionalSort) {
        Integer page = 0;
        Integer size = 10;
        String sort = "name";
        String name = "";
        String idUser = userID.get("id");
        Page<Playlist> playlists;
        if (optionalPage.isPresent()) page = Integer.parseInt(optionalPage.get());
        if (optionalSize.isPresent()) size = Integer.parseInt(optionalSize.get());
        if (optionalSort.isPresent()) sort = optionalSort.get();
        if (nameSearch.isPresent()) name = nameSearch.get();

        Pageable pageable =PageRequest.of(page, size,Sort.by(sort));
        if (idUser!=null){
            playlists = playlistService.findAllByNameAndUserID(name,Long.parseLong(idUser), pageable);
        }
        else
            playlists = playlistService.findAllByName( name, pageable);
//        playlists = playlistService.findAllByName( name, pageable);
        if (playlists.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        ///check null
        return new ResponseEntity<>(tuConverterDTO.playlistConvertPlaylistDTO(playlists,pageable), HttpStatus.OK);
    }


    // playlist of user
    @GetMapping("/user/{id}")
    public ResponseEntity<Iterable<PlaylistDTO>> getAllPlaylistByUser(@PathVariable("id") Long id,
                                                                      @RequestParam("page") Optional<String> optionalPage,
                                                                      @RequestParam("size") Optional<String> optionalSize,
                                                                      @RequestParam("sort") Optional<String> optionalSort){
        Integer page = 0;
        Integer size =10;
        String sort = "name";
        if (optionalPage.isPresent()) page = Integer.parseInt(optionalPage.get());
        if (optionalSize.isPresent()) size = Integer.parseInt(optionalSize.get());
        if (optionalSort.isPresent()) sort = optionalSort.get();
        Pageable pageable =PageRequest.of(page, size,Sort.by(sort));
        Page<Playlist> playlists = playlistService.findAllByUserId(id, pageable);
        if (playlists.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        // do du lieu tu user ra
        return new ResponseEntity<>(tuConverterDTO.playlistConvertPlaylistDTO(playlists,pageable), HttpStatus.OK);
    }



    // create playlist
    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        Playlist playlistCreate =  playlistService.save(playlist);
        if (playlistCreate.toString().isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(playlistService.save(playlist), HttpStatus.CREATED);
    }


    // edit playlist
    @PutMapping("/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@RequestBody PlaylistDTO playlistDTO, @PathVariable Long id) {
        Playlist playlist = tuConverterDTO.playlistConvert(playlistDTO);
        Optional<Playlist> playlistOptional = playlistService.findById(id);
        if (playlistOptional.isPresent()) {
            playlist.setId(id);
            return new ResponseEntity<>(playlistService.save(playlist), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // delete playlist(them truong),
    @DeleteMapping("/{id}")
    public ResponseEntity<Playlist> deletePlaylist(@PathVariable Long id) {
        Optional<Playlist> playlist = playlistService.findById(id);
        if (playlist.isPresent()) {
            playlist.get().setStatus(false);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}