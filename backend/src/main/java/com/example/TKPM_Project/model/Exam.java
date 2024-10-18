package com.example.TKPM_Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(nullable = false)
    private String category; // Loại đề thi (Listening, Reading, Writing, Speaking)

    @Column(name = "created_by")
    private String createdBy; // Người tạo đề

    // Getters và Setters
}
