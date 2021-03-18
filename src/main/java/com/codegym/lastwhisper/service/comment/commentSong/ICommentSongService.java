package com.codegym.lastwhisper.service.comment.commentSong;

import com.codegym.lastwhisper.model.CommentSong;
import com.codegym.lastwhisper.model.Song;
import com.codegym.lastwhisper.service.comment.IService;
import org.springframework.stereotype.Service;

@Service
public interface ICommentSongService extends IService<CommentSong> {
    Iterable<CommentSong> getCommentSongsBySongOrderByCreationTimeDesc(Song song);
}
