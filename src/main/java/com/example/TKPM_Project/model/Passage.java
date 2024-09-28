package com.example.TKPM_Project.model;


import jakarta.persistence.*;

@Entity
@Table(name = "passages")
public class Passage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "difficulty_level", nullable = false)
    private String difficultyLevel; // Example: "easy", "medium", "hard"

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    // Getters và Setters
}