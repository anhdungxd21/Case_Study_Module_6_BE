package com.codegym.lastwhisper.api;
import com.codegym.lastwhisper.model.Playlist;
import com.codegym.lastwhisper.service.playlist.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("/playlist")
public class PlaylistApi {

    @Autowired
    private IPlaylistService playlistService;
    // list playlist
    @GetMapping
    public ResponseEntity<Iterable<Playlist>> getAllPlaylist(@RequestParam("page") Optional<String> optionalPage,
                                                             @RequestParam("size") Optional<String> optionalSize,
                                                             @RequestParam("sort") Optional<String> sort){
        Integer page=0;
        Integer size=2;
        if (optionalPage.isPresent()) page=Integer.parseInt(optionalPage.get());
        if (optionalSize.isPresent()) size=Integer.parseInt(optionalSize.get());
        Pageable pageable =  PageRequest.of(page,size, Sort.by("namePlaylist"));
        return new ResponseEntity<>(playlistService.findAll(pageable), HttpStatus.OK);
    }
    // create playlist
    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist){
        return new ResponseEntity<>(playlistService.save(playlist),HttpStatus.CREATED);
    }
    // edit playlist
    @PutMapping("/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@RequestBody Playlist playlist,@PathVariable Long id){
        Optional<Playlist> playlistOptional= playlistService.findById(id);
        if (playlistOptional.isPresent()) {
            playlist.setId(id);
            return new ResponseEntity<>(playlistService.save(playlist),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // delete playlist
    @DeleteMapping("/{id}")
    public ResponseEntity<Playlist> deletePlaylist(@PathVariable Long id){
        Optional<Playlist> playlist = playlistService.findById(id);
        if (playlist.isPresent()){
            playlistService.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // find one by id for show detail
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> playlistDetail(@PathVariable Long id){
        Optional<Playlist> playlist= playlistService.findById(id);
        if (playlist.isPresent()){
            return new ResponseEntity<>(playlist.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // sreach by name
    @GetMapping("/search")
    public ResponseEntity<Iterable<Playlist>> getAllEmployeeByName(@RequestParam("name")String nameSearch){
        Integer page = 0;
        Integer size = 2;
        Pageable pageable = PageRequest.of(page,size);
        return new ResponseEntity<>(playlistService.findAllByName(nameSearch,pageable),HttpStatus.OK);
    }
}
