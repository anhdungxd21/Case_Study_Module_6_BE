package com.c0920i1.lastWishper.service.singer;

import com.c0920i1.lastWishper.model.Singer;
import com.c0920i1.lastWishper.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SingerService implements ISingerService {

    @Autowired
    private SingerRepository singerRepository;

    @Override
    public Optional<Singer> findById(Long id) {
        return singerRepository.findById(id);
    }

    @Override
    public Iterable<Singer> findAll() {
        return singerRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        singerRepository.findAll();
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    public Iterable<Singer> findAllByNameContains(String name) {
        return singerRepository.findAllByNameContains(name);
    }

}
