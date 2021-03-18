package com.codegym.lastwhisper.dto;

import com.codegym.lastwhisper.model.Song;

public class converter {

    public static Song songConverter(SongDTO songDTO){
        Song song = new Song();
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

        return song;
    }
}
