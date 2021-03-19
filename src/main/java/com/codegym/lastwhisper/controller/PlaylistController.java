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
import java.util.Optional;
import java.util.function.Function;

@CrossOrigin("*")
@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private IPlaylistService playlistService;
    @Autowired
    private TuConverterDTO tuConverterDTO;

    // list playlist
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
        return new ResponseEntity<>(playlistConvertPlaylistDTO(playlists,pageable), HttpStatus.OK);
    }

    // create playlist
    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        return new ResponseEntity<>(playlistService.save(playlist), HttpStatus.CREATED);
    }

    // edit playlist
    @PutMapping("/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@RequestBody Playlist playlist, @PathVariable Long id) {
        Optional<Playlist> playlistOptional = playlistService.findById(id);
        if (playlistOptional.isPresent()) {
            playlist.setId(id);
            return new ResponseEntity<>(playlistService.save(playlist), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // delete playlist
    @DeleteMapping("/{id}")
    public ResponseEntity<Playlist> deletePlaylist(@PathVariable Long id) {
        Optional<Playlist> playlist = playlistService.findById(id);
        if (playlist.isPresent()) {
            playlistService.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // find one by id for show detail
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> playlistDetail(@PathVariable Long id) {
        Optional<Playlist> playlist = playlistService.findById(id);
        if (playlist.isPresent()) {
            return new ResponseEntity<>(playlist.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // sreach by name
    @GetMapping("/search/{id}")
    public ResponseEntity<Iterable<PlaylistDTO>> getAllPlaylistByName(@RequestParam("name") Optional<String> nameSearch,
                                                                   @PathVariable("id") Long userID,
                                                                   @RequestParam("page") Optional<String> optionalPage,
                                                                   @RequestParam("size") Optional<String> optionalSize,
                                                                   @RequestParam("sort") Optional<String> optionalSort) {
        Integer page = 0;
        Integer size = 10;
        String sort = "name";
        String name = "";
        if (optionalPage.isPresent()) page = Integer.parseInt(optionalPage.get());
        if (optionalSize.isPresent()) size = Integer.parseInt(optionalSize.get());
        if (optionalSort.isPresent()) sort = optionalSort.get();
        if (nameSearch.isPresent()) name = nameSearch.get();
        Pageable pageable =PageRequest.of(page, size,Sort.by(sort));
        Page<Playlist> playlists = playlistService.findAllByNameAndUserID(name, userID, pageable);
        return new ResponseEntity<>(playlistConvertPlaylistDTO(playlists,pageable), HttpStatus.OK);
    }

    // playlist by playlist
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

        // do du lieu tu user ra
        return new ResponseEntity<>(playlistConvertPlaylistDTO(playlists,pageable), HttpStatus.OK);
    }
    private Page<PlaylistDTO> playlistConvertPlaylistDTO(Page<Playlist> playlists, Pageable pageable){
        List<PlaylistDTO> playlistDTOS= new ArrayList<PlaylistDTO>();
        for (Playlist playlist: playlists.getContent()) {
            playlistDTOS.add(tuConverterDTO.playlistDTOConvert(playlist));
        }
        Page<PlaylistDTO> playlistDTOPage = new PageImpl( playlistDTOS, pageable, playlists.getTotalElements());
        return playlistDTOPage;
    }
}