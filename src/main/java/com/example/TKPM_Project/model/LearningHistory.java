package com.example.TKPM_Project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "learning_history")
public class LearningHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "exam_id", nullable = false)
    private Integer examId;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = true) // Allowing end_time to be null if the session is ongoing
    private LocalDateTime endTime;

    @Column(name = "status", nullable = false) // For example: "in_progress", "completed", etc.
    private String status;

    // Getters và Setters
}