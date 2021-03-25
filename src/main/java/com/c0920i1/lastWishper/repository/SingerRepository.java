package com.c0920i1.lastWishper.repository;

import com.c0920i1.lastWishper.model.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SingerRepository extends JpaRepository<Singer, Long> {
    public Iterable<Singer> findAllByNameContains(String name);
    public Optional<Singer> findByName(String name);
    public Page<Singer> findAllByNameContains(String name,Pageable pageable);
}
