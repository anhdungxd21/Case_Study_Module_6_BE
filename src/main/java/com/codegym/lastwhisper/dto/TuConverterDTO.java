package com.codegym.lastwhisper.dto;

import com.codegym.lastwhisper.model.Playlist;
import com.codegym.lastwhisper.model.PlaylistSong;
import com.codegym.lastwhisper.model.Song;
import com.codegym.lastwhisper.model.User;
import com.codegym.lastwhisper.service.playlist.IPlaylistService;
import com.codegym.lastwhisper.service.playlist.IPlaylistSong;
import com.codegym.lastwhisper.service.song.ISongService;
import com.codegym.lastwhisper.service.user.IUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Data
@Component
public class TuConverterDTO {
    @Autowired
    private IPlaylistService playlistService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IPlaylistSong playlistSongService;
    @Autowired
    private ISongService songService;

    public Playlist playlistConvert(PlaylistDTO playlistDTO){
        Playlist playlist = new Playlist(playlistDTO.getId(), playlistDTO.getName(), playlistDTO.getDescription(),
                                         playlistDTO.getAvatar(),playlistDTO.getUser().getId());
        return playlist;
    }
    public PlaylistDTO playlistDTOConvert(Playlist playlist){
        UserDTO userDTO =getUserDtoById(playlist.getUserId());
        PlaylistDTO playlistDTO = new PlaylistDTO(playlist.getId(),playlist.getName(),
                                                  playlist.getAvatar(),playlist.getDescription(),
                                                   userDTO);
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
    public UserDTO getUserDtoById(Long id){
        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(id);
            userDTO.setUsername(optionalUser.get().getUsername());
            return userDTO;
        }else {
            return null;
        }
    }

    /// list song in playlist
    public PlaylistSongDTO playlistSongDTOConvert(PlaylistSong playlistSong){
        PlaylistSongDTO playlistSongDTO = new PlaylistSongDTO();
        Optional<Playlist> playlist = playlistService.findById(playlistSong.getPlaylistId());
        Optional<Song> song = songService.findById(playlistSong.getSongId());
        if (!playlist.isPresent() && !song.isPresent() ) return null;
        playlistSongDTO.setId(playlistSong.getId());
        playlistSongDTO.setPlaylist(playlist.get());
        playlistSongDTO.setSong(song.get());
        return playlistSongDTO;
    }
    public PlaylistSong playlistSongConvert(PlaylistSongDTO playlistSongDTO){
        return new PlaylistSong(playlistSongDTO.getId(), playlistSongDTO.getPlaylist().getId(),playlistSongDTO.getSong().getId());
    }
}
