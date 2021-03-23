package com.c0920i1.lastWishper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, length = 50)
    private String address;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @Column(nullable = false, unique = true, length = 50)
    private String tel;
    private String avatar;
    @OneToOne
    @JsonIgnore
    private User user;

}
