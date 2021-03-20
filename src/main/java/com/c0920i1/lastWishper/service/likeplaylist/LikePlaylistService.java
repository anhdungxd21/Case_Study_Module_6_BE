package com.c0920i1.lastWishper.service.likeplaylist;

import com.c0920i1.lastWishper.model.LikePlaylist;
import com.c0920i1.lastWishper.model.LikePlaylistId;
import com.c0920i1.lastWishper.repository.LikePlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikePlaylistService implements ILikePlaylistService{
    @Autowired
    private LikePlaylistRepository likePlaylistRepository;
    @Override
    public Iterable<LikePlaylist> findAll() {
        return likePlaylistRepository.findAll();
    }

    @Override
    public Optional<LikePlaylist> findById(LikePlaylistId likePlaylistId) {
        return likePlaylistRepository.findById(likePlaylistId);
    }

    @Override
    public LikePlaylist save(LikePlaylist likePlaylist) {
        return likePlaylistRepository.save(likePlaylist);
    }

    @Override
    public void delete(LikePlaylistId likePlaylistId) {
        likePlaylistRepository.deleteById(likePlaylistId);
    }
}
