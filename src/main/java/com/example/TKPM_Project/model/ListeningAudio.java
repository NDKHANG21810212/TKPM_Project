package com.example.TKPM_Project.model;


import jakarta.persistence.*;

@Entity
@Table(name = "listening_audio")
public class ListeningAudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "audio_path", nullable = false)
    private String audioPath;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    // Getters và Setters
}