package com.codegym.lastwhisper.repository;

import com.codegym.lastwhisper.model.Playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPlaylist extends JpaRepository<Playlist, Long> {
    Page<Playlist> findAllByNameContains(String namePlaylist, Pageable pageable);
    Page<Playlist> findAllByUserIdContains(Long id, Pageable pageable);
}
