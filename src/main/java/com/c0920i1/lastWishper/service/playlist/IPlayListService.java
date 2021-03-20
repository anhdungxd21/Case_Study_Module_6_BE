package com.c0920i1.lastWishper.service.playlist;

import com.c0920i1.lastWishper.model.Playlist;
import com.c0920i1.lastWishper.model.Track;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public interface IPlayListService {
    Iterable<Playlist> getAll();
    Playlist save (Playlist playlist);
    Optional<Playlist> findById(Long id);
    void remove(Long id);
    Iterable<Playlist> findAllByUserUsername(String username);
    Playlist addSongToPlaylist(Long idSong, Long idPlaylist);
    Iterable<Playlist> listLatest();
    Iterable<Playlist> topView();
    List<Playlist> topLike();
    List<BigInteger> likeNumber();
    List<Track> getTrackPlaylistById(Long idPlaylist);
    Iterable<Playlist> findByName(String keyword);
}
