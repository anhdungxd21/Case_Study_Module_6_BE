package com.codegym.lastwhisper.service.song;

import com.codegym.lastwhisper.model.Song;
import com.codegym.lastwhisper.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {
    @Autowired
    private SongRepository songRepository;

    @Transactional
    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAllByStatus(true);
    }

    @Transactional
    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    @Transactional
    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        Optional<Song> song =  songRepository.findById(id);
        if(song.isPresent()){
            song.get().setStatus(false);
            songRepository.save(song.get());
        }
    }

    @Transactional
    @Override
    public List<Song> findAllByNameContains(String name) {
        return songRepository.findAllByNameContains(name);
    }
}
