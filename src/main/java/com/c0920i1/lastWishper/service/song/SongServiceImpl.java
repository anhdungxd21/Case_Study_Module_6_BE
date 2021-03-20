package com.c0920i1.lastWishper.service.song;

import com.c0920i1.lastWishper.model.Song;
import com.c0920i1.lastWishper.repository.LikeSongRepository;
import com.c0920i1.lastWishper.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private LikeSongRepository likeSongRepository;
    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Iterable<Song> listLatest() {
        return songRepository.findAllByCreationTimeOrderByCreationTime();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void delete(Long id) {
        songRepository.deleteById(id);
    }








    @Override
    public Iterable<Song> listSongsByUser(Long id) {
        return songRepository.findAllByUserId(id);
    }

    @Override
    public Iterable<Song> findByName(String keyword) {
        return songRepository.findAllByNameContains(keyword);
    }
    @Override
    public Iterable<Song> getList10SongInTopView() {
        return songRepository.findAllByNumberOfViewOrderByNumberOfView();
    }

    @Override
    public Iterable<Song> findAllByUserId(Long idUser) {
        return songRepository.findAllByUserId(idUser);
    }

    @Override
    public Iterable<Song> topLikeSong() {
        Iterable<BigInteger> likeSong = likeSongRepository.findAllByUserLike();
        List<Long> array = new ArrayList<>();
        List<Song> songs = new ArrayList<>();

        for (BigInteger like : likeSong){
            Long longNumber= like.longValue();
            array.add(longNumber);
        }
        for (Long e: array){
            songs.add(songRepository.findById(e).get());
        }
        return songs;
    }

    @Override
    public List<BigInteger> likeNumber() {
        List<BigInteger> likeNumberOfSong = likeSongRepository.findAllByLikeNumberOfSong();
        return likeNumberOfSong;
    }


}

