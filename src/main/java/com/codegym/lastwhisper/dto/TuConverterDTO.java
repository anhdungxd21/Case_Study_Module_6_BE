package com.codegym.lastwhisper.dto;

import com.codegym.lastwhisper.model.Playlist;
import com.codegym.lastwhisper.service.playlist.IPlaylistService;
import com.codegym.lastwhisper.service.user.IUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class TuConverterDTO {
    @Autowired
    private IPlaylistService playlistService;
    @Autowired
    private IUserService userService;

    private Playlist playlistConvert(PlaylistDTO playlistDTO){
        Playlist playlist = new Playlist();
        long id  = userService.findByUserName(playlistDTO.getUserFullName()).getId();
        playlist.setUserId(id);
        return playlist;
    }
    private PlaylistDTO playlistDTOConvert(Playlist playlist){
        PlaylistDTO playlistDTO = new PlaylistDTO();
        String fullName = userService.findById(playlist.getUserId()).get().getUsername();
        long id11 =playlist.getUserId();
        String test= userService.findById(id11).get().getUsername();
        playlistDTO.setUserFullName(fullName);
        playlistDTO.setId(playlist.getId());
        playlistDTO.setAvatar(playlist.getAvatar());
        playlistDTO.setDescription(playlist.getDescription());
        playlistDTO.setName(playlist.getName());
        return playlistDTO;
    }

    public Page<PlaylistDTO> playlistConvertPlaylistDTO(Page<Playlist> playlists, Pageable pageable){
        List<PlaylistDTO> playlistDTOS= new ArrayList<PlaylistDTO>();
        for (Playlist playlist: playlists.getContent()) {
            playlistDTOS.add(playlistDTOConvert(playlist));
        }
        Page<PlaylistDTO> playlistDTOPage = new PageImpl( playlistDTOS, pageable, playlists.getTotalElements());
        return playlistDTOPage;
    }
}
