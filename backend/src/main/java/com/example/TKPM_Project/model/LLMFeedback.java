package com.example.TKPM_Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "llm_feedbacks")
public class LLMFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "result_id", nullable = false)
    private Result result;

    @Column(nullable = false)
    private String feedbackText;

    @Column
    private String suggestions; // Gợi ý cải thiện

    // Getters và Setters
}
