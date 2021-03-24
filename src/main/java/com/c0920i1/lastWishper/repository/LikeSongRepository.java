package com.c0920i1.lastWishper.repository;

import com.c0920i1.lastWishper.model.LikeSong;
import com.c0920i1.lastWishper.model.LikeSongId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface LikeSongRepository extends CrudRepository<LikeSong, LikeSongId> {
    @Query(value = "select id from song\n" +
            "    join (select count(user_id) as like_number, song_id\n" +
            "    from like_song group by song_id order by like_number desc)\n" +
            "        likesong where id = likesong.song_id\n" +
            "order by likesong.like_number desc limit 10", nativeQuery = true)
    Iterable<BigInteger> findAllByUserLike();

    @Query(value = "select count(user_id) as like_number, song_id\n" +
            "from like_song group by song_id\n" +
            "order by like_number desc limit 10;", nativeQuery = true)
    List<BigInteger> findAllByLikeNumberOfSong();

}
