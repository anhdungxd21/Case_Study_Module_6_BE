package com.c0920i1.lastWishper.service.commentSong;

import com.c0920i1.lastWishper.model.CommentSong;
import com.c0920i1.lastWishper.model.Song;
import com.c0920i1.lastWishper.service.IGeneralService;
import org.springframework.stereotype.Service;

@Service
public interface CommentSongService extends IGeneralService<CommentSong> {
    Iterable<CommentSong> getCommentSongsBySongOrderByCreationTimeDesc(Song song);
//    Iterable<CommentSong> findAllByCreationTimeOrderByCreationTime();
}
