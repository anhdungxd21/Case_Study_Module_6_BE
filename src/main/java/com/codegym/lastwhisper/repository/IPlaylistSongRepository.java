package com.codegym.lastwhisper.repository;

import com.codegym.lastwhisper.model.PlaylistSong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IPlaylistSongRepository  extends JpaRepository<PlaylistSong, Long> {
    Page<PlaylistSong> findAllByPlaylistId(Pageable pageable, Long id);
    Iterable<PlaylistSong> findAllByPlaylistId(Long id);
}
