package com.c0920i1.lastWishper.repository;

import com.c0920i1.lastWishper.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayListRepository extends JpaRepository<Playlist, Long> {
    Iterable<Playlist> findAllByUserUsername(String username);

    @Query(value = "select * from playlist order by creation_time desc limit 10", nativeQuery = true)
    Iterable<Playlist> findAllByCreationTimeOrderByCreationTime();

    @Query(value = "select * from playlist order by view desc limit 10", nativeQuery = true)
    Iterable<Playlist> findAllByViewOrderByView();

    Iterable<Playlist> findAllByNameContains(String keyword);

}