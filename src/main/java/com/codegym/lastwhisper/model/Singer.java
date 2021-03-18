package com.codegym.lastwhisper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Long   id;
    private String fullName;
=======
    private Long id;
    private String name;
>>>>>>> f0e4d29f4187d35d7b4a81522684d992f5f447f3
    private String gender;
    private String birthday;
    private String description;
}
