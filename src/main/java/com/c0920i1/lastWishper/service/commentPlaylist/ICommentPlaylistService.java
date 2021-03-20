package com.c0920i1.lastWishper.service.commentPlaylist;

import com.c0920i1.lastWishper.model.CommentPlaylist;
import com.c0920i1.lastWishper.model.Playlist;
import com.c0920i1.lastWishper.service.IGeneralService;
import org.springframework.stereotype.Service;

@Service
public interface ICommentPlaylistService extends IGeneralService<CommentPlaylist> {
    Iterable<CommentPlaylist> getCommentPlaylistsByPlaylist(Playlist playlist);
}
