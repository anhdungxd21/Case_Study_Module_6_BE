package com.codegym.lastwhisper.dto;

import com.codegym.lastwhisper.model.Singer;
import com.codegym.lastwhisper.model.Song;
import com.codegym.lastwhisper.model.User;
import com.codegym.lastwhisper.model.Type;
import com.codegym.lastwhisper.service.song.ISongService;
import com.codegym.lastwhisper.service.singer.ISingerService;
import com.codegym.lastwhisper.service.type.ITypeService;
import com.codegym.lastwhisper.service.user.IUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

@Data
@Component
public class ConverterDTO {

    @Autowired
    private ISongService songService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ISingerService singerService;

    @Autowired
    private ITypeService typeService;


    public ZonedDateTime getTime(){
        ZoneId zoneHCM = ZoneId.of("Asia/Ho_Chi_Minh");

        // Creating LocalDateTime by providing input arguments
        LocalDateTime today = LocalDateTime.now();

        // Creating ZonedDateTime by providing input arguments
        ZonedDateTime hcmDateTime = ZonedDateTime.of(today, zoneHCM);

        return hcmDateTime;
    }

    public  Song songConverter(SongDTO songDTO){

        ZonedDateTime date = getTime();
        Song song = new Song();



        if(songDTO.getId()!=null){
            song.setId(songDTO.getId());
            song.setCreateDate(songService.findById(songDTO.getId()).get().getCreateDate());

        }else{
            song.setCreateDate(date);
        }

        song.setUpdateDate(date);

        if(songDTO.getName()!=null){

            song.setName(songDTO.getName());
        }else {
            song.setName("Unknown");
        }

        if(songDTO.getLink()!=null){
            song.setLink(songDTO.getLink());
        } else {
            return null;
        }

        if(songDTO.getLyric()!=null){
            song.setLyric(songDTO.getLyric());
        }

        if(songDTO.getUserId()!=null){
            song.setUserId(songDTO.getUserId());
        } else {
            song.setUserId(1l);
        }

        if(songDTO.getTypeId()!=null){
            song.setTypeId(songDTO.getTypeId());
        }
        if(songDTO.getSingerId()!=null){
            song.setSingerId(songDTO.getSingerId());
        }else{
            song.setSingerId(1l);
        }

        return song;
    }

    public SongJsonDto converterSongToSend(Song song){
        SongJsonDto songJsonDto = new SongJsonDto();
        songJsonDto.setId(song.getId());
        songJsonDto.setName(song.getName());
        songJsonDto.setLink(song.getLink());
        songJsonDto.setLyric(song.getLyric());

        Optional<Type> type = typeService.findById(song.getTypeId());
        if(type.isPresent()){
            songJsonDto.setType(type.get());
        }else {
            songJsonDto.setType(null);
        }

        songJsonDto.setUser(getUserDtoById(song.getUserId()));

        Optional<Singer> singer = singerService.findById(song.getSingerId());
        if(singer.isPresent()) {
            songJsonDto.setSinger(singer.get());
        }else{
            songJsonDto.setSinger(null);
        }
        return songJsonDto;
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
}
