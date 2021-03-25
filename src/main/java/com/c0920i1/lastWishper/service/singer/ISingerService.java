package com.c0920i1.lastWishper.service.singer;

import com.c0920i1.lastWishper.model.Singer;
import com.c0920i1.lastWishper.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ISingerService extends IGeneralService<Singer> {
    public Iterable<Singer> findAllByNameContains(String name);
    public Optional<Singer> findByName(String name);
    public Page<Singer> findAllByNameContains(String name,Pageable pageable);
    public Page<Singer> findAll(Pageable pageable);
}
