package com.codegym.lastwhisper.repository;

import com.codegym.lastwhisper.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends PagingAndSortingRepository<Song, Long> {
    Page<Song> findAll(Pageable pageable);
    List<Song> findAllByNameContains(String name);
    Optional<Song> findAllByUserId(Long id);
}
