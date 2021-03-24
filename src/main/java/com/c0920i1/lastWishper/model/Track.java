package com.c0920i1.lastWishper.model;

import lombok.Data;

@Data
public class Track {
    private Long index;
    private String link;
    private String title;
    private Long startOffset;
    private Long endOffset;
    private Long duration;
    private String artist;
}
