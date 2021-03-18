package com.codegym.lastwhisper.service.comment.commentPlaylist;

import com.codegym.lastwhisper.model.CommentPlaylist;
import com.codegym.lastwhisper.model.Playlist;
import com.codegym.lastwhisper.service.comment.IService;
import org.springframework.stereotype.Service;

@Service
public interface ICommentPlaylistService extends IService<CommentPlaylist> {
    Iterable<CommentPlaylist> getCommentPlaylistsByPlaylist(Playlist playlist);
}