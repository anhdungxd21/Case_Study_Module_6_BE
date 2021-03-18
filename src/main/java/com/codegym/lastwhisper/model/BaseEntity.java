package com.codegym.lastwhisper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;

import java.time.ZonedDateTime;

public abstract class BaseEntity {
    @JsonIgnore
    @CreatedBy
    private String createBy;

    @JsonIgnore
    @CreatedBy
    private ZonedDateTime createDate;

    @JsonIgnore
    @CreatedBy
    private String updateBy;

//    @JsonIgnore
//    private String version;
}
