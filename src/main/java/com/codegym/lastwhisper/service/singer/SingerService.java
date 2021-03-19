package com.codegym.lastwhisper.service.singer;

import com.codegym.lastwhisper.model.Singer;
import com.codegym.lastwhisper.repository.ISingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SingerService implements ISingerService{

    @Autowired
    private ISingerRepository singerRepository;

    @Override
    public Page<Singer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<Singer> findAll() {
        return singerRepository.findAll();
    }

    @Override
    public Optional<Singer> findById(Long id) {
        return singerRepository.findById(id);
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    public void remove(Long id) {
        singerRepository.deleteById(id);
    }
}
