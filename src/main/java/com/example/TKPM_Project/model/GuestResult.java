package com.example.TKPM_Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "guest_results")
public class GuestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    @Column(name = "score", nullable = false)
    private Double score;

    // Getters và Setters
}