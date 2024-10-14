package com.example.TKPM_Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "learning_history")
public class LearningHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    @Column(nullable = false)
    private String status; // Trạng thái (Hoàn thành, Đang làm, Đã nộp)

    @Column(nullable = false)
    private Integer attempts; // Số lần làm lại

    // Getters và Setters
}
