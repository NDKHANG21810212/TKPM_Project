package com.example.TKPM_Project.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Audio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String path;

    @OneToMany(mappedBy = "audio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

    // Getters and Setters
}
